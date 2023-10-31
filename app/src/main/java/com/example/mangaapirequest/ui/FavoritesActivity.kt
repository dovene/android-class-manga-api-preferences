package com.example.mangaapirequest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangaapirequest.model.Data
import com.example.mangaapirequest.R
import com.example.mangaapirequest.data.SharedPreferencesManager
import com.example.mangaapirequest.databinding.ActivityFavoritesBinding


class FavoritesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoritesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.favorites)
        setViewItems()
    }

    private fun setViewItems() {
        val localMangas = SharedPreferencesManager().getLocalMangaStorage(this).localMangas
        displayMangaList(localMangas)
    }

    fun displayMangaList(mangas: MutableList<Data>) {
        val adapter = MangaListViewAdapter(mangas, object : MangaItemCallback {
            override fun onCellClick(manga: Data) {
            }

            override fun onSaveManga(manga: Data) {
                deleteManga(manga)
            }
        })
        binding.mangaRv.adapter = adapter
        binding.mangaRv.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun deleteManga(manga: Data) {
        SharedPreferencesManager().deleteManga(manga, this)
        displayMangaList(SharedPreferencesManager().getLocalMangaStorage(this).localMangas)
    }
}