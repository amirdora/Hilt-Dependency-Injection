package com.amirdora.hiltdi_sampleapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDAO(): AppDao

    companion object {
        private var dbInstance: AppDatabase? = null

        fun getAppDB(context: Context): AppDatabase {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext, AppDatabase::class.java, "MyDb"
                ).allowMainThreadQueries()
                    .build()
            }
            return dbInstance!!
        }
    }
}