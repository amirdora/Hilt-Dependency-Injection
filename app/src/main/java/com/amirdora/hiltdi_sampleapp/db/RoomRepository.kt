package com.amirdora.hiltdi_sampleapp.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getRecords(): List<UserEntity> {
        return appDao.getRecords()
    }

    fun insertRecord(user: UserEntity) {
        return appDao.insertRecord(user)
    }
}