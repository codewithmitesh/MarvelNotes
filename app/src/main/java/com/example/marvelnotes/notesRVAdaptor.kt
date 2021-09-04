package com.example.marvelnotes

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class notesRVAdaptor(val context: Context, private val listner: InotesRVAdaptor) :
    RecyclerView.Adapter<notesRVAdaptor.NoteViewHolder>() {

    private val allNotes = ArrayList<Notes>()


    inner class NoteViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {


        val textview = itemview.findViewById<TextView>(R.id.NoteText);
        val button = itemview.findViewById<ImageView>(R.id.ImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
        viewHolder.button.setOnClickListener {
            listner.onItemClicked(allNotes[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textview.text = currentNote.text

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Notes>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()

    }

}

interface InotesRVAdaptor {
    fun onItemClicked(notes: Notes)

}