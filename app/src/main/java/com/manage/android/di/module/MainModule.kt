package com.manage.android.di.module

import androidx.lifecycle.ViewModel
import com.manage.android.di.ViewModelKey
import com.manage.android.ui.main.MainActivity
import com.manage.android.ui.main.MainNavigator
import com.manage.android.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel

    abstract fun bindMainNavigator(): MainNavigator


}