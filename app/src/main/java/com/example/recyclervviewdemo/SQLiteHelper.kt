package com.example.recyclervviewdemo

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.recyclervviewdemo.models.Note

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "notes_db"
        private const val DATABASE_VERSION = 1
        private const val TBL_NOTES = "Notes"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Notes (Number INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT NOT NULL, Body TEXT NOT NULL)")
        db?.execSQL("INSERT INTO Notes (Title, Body) VALUES ('Test #1', 'Test #1 note body')")
        db?.execSQL("INSERT INTO Notes (Title, Body) VALUES ('Test #2', 'Test #2 note body')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    @SuppressLint("Range")
    fun getAllNotes(): ArrayList<Note> {

        val noteList: ArrayList<Note> = ArrayList()
        val db = this.readableDatabase

        db.rawQuery("SELECT * FROM $TBL_NOTES", null).use { cursor ->
            if (cursor.moveToFirst()) {
                do {
                    noteList.add(Note(
                        number = cursor.getInt(cursor.getColumnIndex("Number")),
                        title = cursor.getString(cursor.getColumnIndex("Title")),
                        body = cursor.getString(cursor.getColumnIndex("Body"))
                    ))
                } while (cursor.moveToNext())
            }

            return noteList
        }
    }
}