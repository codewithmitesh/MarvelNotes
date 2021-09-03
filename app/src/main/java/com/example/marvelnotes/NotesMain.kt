package com.example.marvelnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class NotesMain : AppCompatActivity() {

      lateinit var viewmodel: NoteViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_main)

         viewmodel = ViewModelProvider(this).get(NoteViewModel::class.java)
         viewmodel.allNotes.observe(this, Observer(){

         })
    }


}