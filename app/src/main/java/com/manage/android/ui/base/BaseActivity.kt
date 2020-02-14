package com.manage.android.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.android.AndroidInjection
import com.manage.android.utils.isInternetAvailable


abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: T
        private set

    private lateinit var viewModel: V

    abstract val getBindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun getViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun openActivityOnTokenExpire() {
        startActivity(com.manage.android.ui.login.newIntent(this))
        finish()
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
        this.viewModel = getViewModel()
        binding.setVariable(getBindingVariable, viewModel)
        binding.executePendingBindings()
    }
}