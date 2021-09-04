package com.example.marvelnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_notes_main.*

class NotesMain : AppCompatActivity(), InotesRVAdaptor {

    lateinit var viewmodel: NoteViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_main)

        notesRecyclerView.layoutManager = LinearLayoutManager(this)
        val adaptor = notesRVAdaptor(this, this)
        notesRecyclerView.adapter = adaptor



        viewmodel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        viewmodel.allNotes.observe(this, Observer() { list ->
            list?.let {
                adaptor.updateList(it)
            }
        })
    }

    override fun onItemClicked(notes: Notes) {
        viewmodel.deleteNote(notes)
        Toast.makeText(this, "${notes.text} ItemDeleted", Toast.LENGTH_SHORT).show()
    }

    fun submitData(view: View) {
        val notetext = InputNotes.text.toString()
        if (notetext.isNotEmpty()) {
            viewmodel.insertNote(Notes(notetext))
            Toast.makeText(this, "$notetext Item Inserted", Toast.LENGTH_SHORT).show()
        }

    }

//    notesRecyclerView


}


