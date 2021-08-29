package com.example.marvelnotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table")
class Notes( @ColumnInfo(name = "Text") val text: String){

    @PrimaryKey(autoGenerate = true) var id: Int = 0;

}




