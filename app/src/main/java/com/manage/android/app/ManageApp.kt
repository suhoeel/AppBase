package com.manage.android.app

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.manage.android.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import dagger.android.DispatchingAndroidInjector



class ManageApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var appLifecycleObserver: AppLifecycleObserver

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        ProcessLifecycleOwner.get()
            .lifecycle
            .addObserver(appLifecycleObserver)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}