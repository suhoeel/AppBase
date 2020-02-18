package com.manage.android.ui.main

import com.manage.android.di.module.LoginModule
import com.manage.android.di.module.MainModule
import com.manage.android.ui.login.LoginActivity
import com.manage.android.ui.main.MainActivity
import com.manage.android.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentProvider {

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun bindMainFragment(): MainFragment



}