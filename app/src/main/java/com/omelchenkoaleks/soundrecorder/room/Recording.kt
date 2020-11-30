package com.omelchenkoaleks.soundrecorder.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recording_table")
data class Recording(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "filePath") var filePath: String = "",
    @ColumnInfo(name = "length") var length: Int = 0,
    @ColumnInfo(name = "time") var time: Long = 0L
)