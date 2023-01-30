package com.example.recyclervviewdemo

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclervviewdemo.Adapters.ItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var sqliteHelper : SQLiteHelper
    private lateinit var recyclerView : RecyclerView
    private lateinit var itemList : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqliteHelper = SQLiteHelper(this)
        init()
    }

//    private fun getNotes()
//    {
//        val noteList = sqliteHelper.getAllNotes()
//        Log.e("ppp" , "${noteList.size}")
//    }

    private fun init()
    {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)

        recyclerView.adapter = ItemAdapter(arrayOf("Foo", "Bar", "Again Foo", "Again Bar", "Bar", "Again Foo", "Again Bar"))

    }


}