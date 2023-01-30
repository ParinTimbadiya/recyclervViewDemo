package com.example.recyclervviewdemo

import kotlin.random.Random

data class NotesModel (
    var  id:Int = getAutoId(),
    var title : String = ""
    )
{
    companion object{
        fun getAutoId() : Int{
            val random = Random
            return random.nextInt(100)
        }
    }
}

