package com.example.recyclervviewdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity

class SQLiteHelper (context:Context) : SQLiteOpenHelper(context , DATABASE_NAME , null , DATABSE_VERSION){

    companion object
    {
        private const val DATABASE_NAME = "notes_db"
        private const val DATABSE_VERSION = 1
        private const val TBL_NOTES = "tbl_notes"
        private const val ID = "id"
        private const val TITLE = "title"
    }

    override fun onCreate(db: SQLiteDatabase?) {
//        val createTableNotes = ("CREATE TABLE " + TBL_NOTES + "(" + ID + " INTEGER PRIMARY KEY," + TITLE + "TEXT" + ")")
//        db?.execSQL(createTableNotes)


//        val createTableNotes = ("CREATE TABLE  $TBL_NOTES (" + ID + " INTEGER PRIMARY KEY," + TITLE + "TEXT" + ")")
//        db?.execSQL(createTableNotes)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_NOTES")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getAllNotes() : ArrayList<NotesModel>{
        val noteList : ArrayList<NotesModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_NOTES"
        val db = this.readableDatabase

        val cursor : Cursor?
        try{
            cursor = db.rawQuery(selectQuery , null)
        }
        catch (e : java.lang.Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return  ArrayList()
        }
        var id : Int
        var title :String

        if (cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                title = cursor.getInt(cursor.getColumnIndex("title")).toString()

                val notes = NotesModel(id = id , title = title)
                noteList.add(notes)
            }while (cursor.moveToNext())
        }
        return noteList
    }
}