package com.example.mangaapirequest.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mangaapirequest.databinding.ActivityMangaDetailBinding

class MangaDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMangaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMangaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setViewItems()
    }

    private fun setViewItems() {
        val mangaTitle = intent.getStringExtra(MainActivity.mangaKey)
        val mangaImage = intent.getStringExtra(MainActivity.imageKey)
        val synopsis = intent.getStringExtra(MainActivity.synopsisKey)


        binding.mangaTitleTv.text = mangaTitle
        binding.mangaSynopsisTv.text = synopsis
        Glide.with(binding.mangaIv.context).load(mangaImage)
            .into(binding.mangaIv)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
