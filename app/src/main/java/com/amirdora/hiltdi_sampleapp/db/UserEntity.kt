package com.amirdora.hiltdi_sampleapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo()
    val id: Int = 0,
    @ColumnInfo()
    val name: String = "0"
)