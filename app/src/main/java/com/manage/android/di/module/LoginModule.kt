package com.manage.android.di.module

import androidx.lifecycle.ViewModel
import com.manage.android.di.ViewModelKey
import com.manage.android.ui.login.LoginViewModel
import com.manage.android.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindViewModel(viewModel: LoginViewModel): ViewModel
}