package com.manage.android.di.module

import android.app.Application
import android.content.Context
import com.manage.android.app.AppLifecycleObserver
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ContextModule {

    @Binds
    abstract fun provideContext(application: Application): Context

}