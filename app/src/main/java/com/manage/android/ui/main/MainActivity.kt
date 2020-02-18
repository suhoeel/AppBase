package com.manage.android.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.manage.android.data.local.db.dao.Category
import com.manage.android.data.local.db.dao.Product
import com.manage.android.ui.base.BaseActivity
import com.manage.android.utils.reAskToTerminate
import com.manage.fundamental.BR
import com.manage.fundamental.R
import com.manage.fundamental.databinding.ActivityMainBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.app_bar.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    HasSupportFragmentInjector {

    override val layoutId: Int = R.layout.activity_main

    override val getBindingVariable: Int = BR.viewModel

    @Inject
    lateinit var mainNavigator: MainNavigator

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var mainViewModel: MainViewModel

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar()

        mainViewModel.categories.observe(this, Observer { category ->
            binding.viewPager.adapter = MainPagerAdapter(category, supportFragmentManager)
            binding.tabLayout.setupWithViewPager(binding.viewPager)
        })
    }

    override fun getViewModel(): MainViewModel {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        return mainViewModel
    }

    private fun setToolbar() {
        binding.layoutAppBar.toolbar.apply {
            setSupportActionBar(this)
            setTitleTextColor(Color.WHITE)
        }
        binding.layoutAppBar.isEnabled = false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add_category -> {
                MaterialDialog(this)
                    .input(hint = "추가할 카테고리 이름") { dialog, text ->
                        mainViewModel.insertCategory(Category(0, text.toString()))
                        mainViewModel.getCategories()
                    }
                    .lifecycleOwner(this)
                    .positiveButton()
                    .show()
                true
            }
            R.id.action_setting -> {
                mainNavigator.toLoginActivity()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        reAskToTerminate()
    }

}
