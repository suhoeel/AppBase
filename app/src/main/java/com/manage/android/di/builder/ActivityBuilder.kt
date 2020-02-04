package com.manage.android.di.builder

import com.manage.android.di.module.LoginModule
import com.manage.android.di.module.MainModule
import com.manage.android.ui.login.LoginActivity
import com.manage.android.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [MainModule::class]
    )
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [LoginModule::class]
    )
    abstract fun bindLoginActivity(): LoginActivity


}