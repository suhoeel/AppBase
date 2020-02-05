package com.manage.android.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manage.android.app.AppLifecycleObserver
import com.manage.android.data.local.db.AppDatabase
import com.manage.android.data.local.db.AppDbHelper
import com.manage.android.di.DatabaseInfo
import com.manage.android.di.ViewModelBuilder
import com.manage.android.di.ViewModelFactory
import com.manage.android.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideAppLifecycleObserver(): AppLifecycleObserver = AppLifecycleObserver()

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): AppDbHelper {
        return appDbHelper
    }

}