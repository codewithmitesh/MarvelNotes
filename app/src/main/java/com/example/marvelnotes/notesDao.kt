package com.example.marvelnotes

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface notesDao {
    @Query("SELECT * FROM Notes_Table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: Notes)

    @Query("DELETE FROM Notes_Table")
    suspend fun delete(notes: Notes)
}