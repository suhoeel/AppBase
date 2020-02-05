package com.manage.android.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manage.android.data.local.db.dao.User

@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

}