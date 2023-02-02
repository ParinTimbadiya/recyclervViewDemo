package com.example.recyclervviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclervviewdemo.adapters.NotesGridAdapter
import com.example.recyclervviewdemo.models.Note

class MainActivity : AppCompatActivity() {

    private lateinit var sqliteHelper : SQLiteHelper
    private lateinit var recyclerView : RecyclerView
    private lateinit var notes : ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqliteHelper = SQLiteHelper(this)
        notes = sqliteHelper.getAllNotes()

        init()
    }

    private fun init()
    {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)

        recyclerView.adapter = NotesGridAdapter(notes)
    }
}