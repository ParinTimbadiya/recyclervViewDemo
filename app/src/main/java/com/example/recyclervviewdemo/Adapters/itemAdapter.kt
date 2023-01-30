package com.example.recyclervviewdemo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclervviewdemo.R


class ItemAdapter(private val itemlist: Array<String>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val divider : View = view.findViewById(R.id.divider)
        val textTitle : TextView = view.findViewById(R.id.textTitle)
        val textBody : TextView = view.findViewById(R.id.textBody)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item , parent , false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textTitle.text = itemlist[position]
        holder.textBody.text = itemlist[position]

    }

    override fun getItemCount(): Int {
       return  itemlist.size
    }
}