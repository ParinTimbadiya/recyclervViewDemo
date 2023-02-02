package com.example.recyclervviewdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclervviewdemo.models.Note
import com.example.recyclervviewdemo.R

class NotesGridAdapter(private val itemList: ArrayList<Note>) : RecyclerView.Adapter<NotesGridAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textTitle : TextView = view.findViewById(R.id.textTitle)
        val textBody : TextView = view.findViewById(R.id.textBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item , parent , false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textTitle.text = itemList[position].title
        holder.textBody.text = itemList[position].body
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }
}