package com.amirdora.hiltdi_sampleapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query ("SELECT * FROM UserEntity ORDER BY id DESC")
    fun getRecords(): List<UserEntity>

    @Insert
    fun insertRecord(user : UserEntity)
}