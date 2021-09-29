package com.amirdora.hiltdi_sampleapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amirdora.hiltdi_sampleapp.db.RoomRepository
import com.amirdora.hiltdi_sampleapp.db.UserEntity
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val repository: RoomRepository) :
    ViewModel() {

    var userData: MutableLiveData<List<UserEntity>> = MutableLiveData()


    private fun loadRecords() {
        val list = repository.getRecords()
        userData.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity) {
        val list = repository.insertRecord(userEntity)
        loadRecords()
    }
}