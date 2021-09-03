package com.example.marvelnotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Notes::class), version = 1, exportSchema = false)
public abstract class noteDatabase : RoomDatabase() {


    abstract fun getnotesDao(): notesDao;

    companion object {

        @Volatile
        private var INSTANCE: noteDatabase? = null

        fun getDatabase(context: Context): noteDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    noteDatabase::class.java,
                    "Notes_Table"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}
