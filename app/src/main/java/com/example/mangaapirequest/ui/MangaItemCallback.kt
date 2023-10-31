package com.example.mangaapirequest.ui

import com.example.mangaapirequest.model.Data

interface MangaItemCallback {
    fun onCellClick(manga: Data)
    fun onSaveManga(manga: Data)
}