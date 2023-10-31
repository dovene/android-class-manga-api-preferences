package com.example.mangaapirequest.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mangaapirequest.model.Data
import com.example.mangaapirequest.R

class MangaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mangaImageIV: ImageView
    private var mangaTitleTV: TextView
    private var containerCL: ConstraintLayout
    private var bookmark: ImageView

    init {
        mangaImageIV = itemView.findViewById(R.id.manga_iv)
        mangaTitleTV = itemView.findViewById(R.id.manga_title_tv)
        containerCL = itemView.findViewById(R.id.container)
        bookmark = itemView.findViewById(R.id.bookmark)
    }

    fun bind(manga: Data, mangaItemCallback: MangaItemCallback) {
        mangaTitleTV.text = manga.title
        Glide.with(mangaImageIV.context).load(manga.images?.jpg?.imageUrl)
            .into(mangaImageIV)
        containerCL.setOnClickListener {
            mangaItemCallback.onCellClick(manga)
        }
        bookmark.setOnClickListener {
            mangaItemCallback.onSaveManga(manga)
        }
    }
}
