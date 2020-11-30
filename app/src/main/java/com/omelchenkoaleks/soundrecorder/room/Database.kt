package com.omelchenkoaleks.soundrecorder.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recording::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract val dao: Dao

    companion object {

        @Volatile
        private var INSTANCE: com.omelchenkoaleks.soundrecorder.room.Database? = null

        fun getInstance(context: Context): com.omelchenkoaleks.soundrecorder.room.Database {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.omelchenkoaleks.soundrecorder.room.Database::class.java,
                        "record_app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance

            }
        }
    }
}

