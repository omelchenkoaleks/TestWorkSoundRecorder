package com.omelchenkoaleks.soundrecorder.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {

    @Insert
    fun insert(record: Recording)

    @Update
    fun update(record: Recording)

    @Query("SELECT * from recording_table WHERE id = :key")
    fun getRecord(key: Int): Recording?

    @Query("DELETE FROM recording_table")
    fun clearAll()

    @Query("DELETE FROM recording_table WHERE id = :key")
    fun removeRecord(key: Int)

    @Query("SELECT * FROM recording_table ORDER BY id DESC")
    fun getAllRecords(): LiveData<MutableList<Recording>>

    @Query("SELECT COUNT(*) FROM recording_table")
    fun getCount(): LiveData<Int>

}