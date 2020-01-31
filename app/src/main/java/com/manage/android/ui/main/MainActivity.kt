package com.manage.android.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.manage.android.ui.base.BaseActivity
import com.manage.fundamental.R
import com.manage.fundamental.databinding.ActivityMainBinding
import javax.inject.Inject
import com.manage.android.di.ViewModelFactory


class MainActivity(
    override val layoutId: Int = R.layout.activity_main
) : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }
    
}
