package com.manage.android.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.manage.android.ui.base.BaseActivity
import com.manage.fundamental.BR
import com.manage.fundamental.R
import com.manage.fundamental.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.activity_main

    override val getBindingVariable: Int = BR.viewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}
