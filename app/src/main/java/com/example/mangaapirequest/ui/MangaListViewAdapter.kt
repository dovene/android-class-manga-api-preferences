package com.example.mangaapirequest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mangaapirequest.model.Data
import com.example.mangaapirequest.R

class MangaListViewAdapter(var data: MutableList<Data>, var mangaItemCallback: MangaItemCallback) : RecyclerView.Adapter<MangaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return MangaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.bind(data[position], mangaItemCallback)
    }
}
