package com.example.marvelnotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>

init {
    val dao = noteDatabase.getDatabase(application).getnotesDao()
    val repository = NoteReposiratory(dao)
    allNotes = repository.allNotes
}


}