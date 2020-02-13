package com.manage.android.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.manage.android.ui.base.BaseActivity
import com.manage.fundamental.BR
import com.manage.fundamental.R
import com.manage.fundamental.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.app_bar.view.*
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.activity_main

    override val getBindingVariable: Int = BR.viewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar()
        setTopTab()
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private fun setToolbar() {
        binding.layoutAppBar.toolbar.apply {
            setSupportActionBar(this)
            setTitleTextColor(Color.WHITE)
        }
        binding.layoutAppBar.isEnabled = false
//        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setTopTab() {
        binding.topTab.addTab(binding.topTab.newTab().setText("1"))
        binding.topTab.addTab(binding.topTab.newTab().setText("2"))
        binding.topTab.addTab(binding.topTab.newTab().setText("3"))
        binding.topTab.addTab(binding.topTab.newTab().setText("4"))
        binding.topTab.addTab(binding.topTab.newTab().setText("5"))
        binding.topTab.addTab(binding.topTab.newTab().setText("6"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_setting -> {
                /*MaterialDialog(this)
                    .input(hint = "추가할 카테고리 이름")
                    .positiveButton {

                    }
                    .lifecycleOwner(this)
                    .show()*/
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}
