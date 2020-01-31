package com.manage.android.di.module

import android.app.Application
import android.content.Context
import com.manage.android.app.AppLifecycleObserver
import com.manage.android.di.ViewModelBuilder
import com.manage.android.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class AppModule {

    @Singleton
    @Provides
    fun provideAppLifecycleObserver(): AppLifecycleObserver = AppLifecycleObserver()

}