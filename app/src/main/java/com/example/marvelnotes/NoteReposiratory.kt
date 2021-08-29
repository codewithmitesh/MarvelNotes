package com.example.marvelnotes

import androidx.lifecycle.LiveData

class NoteReposiratory(private val notesDao: notesDao) {

    val allNotes: LiveData<List<Notes>> = notesDao.getAllNotes()
    suspend fun insert(notes: Notes) {
        notesDao.insert(notes)
    }

    suspend fun delete(notes: Notes) {
        notesDao.delete(notes)
    }



}