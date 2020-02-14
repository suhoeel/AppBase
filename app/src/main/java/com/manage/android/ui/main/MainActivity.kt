package com.manage.android.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.manage.android.data.local.db.dao.Category
import com.manage.android.data.local.db.dao.Product
import com.manage.android.ui.base.BaseActivity
import com.manage.fundamental.BR
import com.manage.fundamental.R
import com.manage.fundamental.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.app_bar.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.activity_main

    override val getBindingVariable: Int = BR.viewModel

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar()
        mainViewModel.categories.observe(this, Observer<List<Category>> { categories ->
            Log.d("TEST", categories.toString())
        })
/*        val list = ArrayList<Product>()
        list.add(Product(1, "2", 3, "4"))*/
        /*val category = Category(0, "봉투")

        binding.add.setOnClickListener {
            MainScope().launch {
                getViewModel().insertCategory(category)
            }
        }
        binding.delete.setOnClickListener {
            MainScope().launch {
                getViewModel().deleteCategory(getViewModel().getAllCategory()[0])
            }
        }
        binding.get.setOnClickListener {
            GlobalScope.launch {
                val list = getViewModel().getAllCategory()
                Log.d("TEST1", list.toString())
                Log.d("TEST2", getViewModel().getAllCategoryWithProduct().toString())
            }
        }*/
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
//        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

 /*   private fun setTopTab() {
        binding.topTab.addTab(binding.topTab.newTab().setText("1"))
        binding.topTab.addTab(binding.topTab.newTab().setText("2"))
        binding.topTab.addTab(binding.topTab.newTab().setText("3"))
        binding.topTab.addTab(binding.topTab.newTab().setText("4"))
        binding.topTab.addTab(binding.topTab.newTab().setText("5"))
        binding.topTab.addTab(binding.topTab.newTab().setText("6"))
    }*/

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
                    }
                    .lifecycleOwner(this)
                    .positiveButton()
                    .show()
                true
            }
            R.id.action_setting -> {
                mainViewModel.getCategories()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}
