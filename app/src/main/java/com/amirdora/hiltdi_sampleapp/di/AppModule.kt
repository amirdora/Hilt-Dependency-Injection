package com.amirdora.hiltdi_sampleapp.di

import android.content.Context
import com.amirdora.hiltdi_sampleapp.db.AppDao
import com.amirdora.hiltdi_sampleapp.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun getAppDb(context: Context) : AppDatabase{
        return AppDatabase.getAppDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDb: AppDatabase) : AppDao{
        return appDb.getDAO()
    }
}