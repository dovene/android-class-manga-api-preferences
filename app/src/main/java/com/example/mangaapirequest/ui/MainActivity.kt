package com.example.mangaapirequest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangaapirequest.model.Data
import com.example.mangaapirequest.service.MangaApi
import com.example.mangaapirequest.model.MangaApiResponse
import com.example.mangaapirequest.data.SharedPreferencesManager
import com.example.mangaapirequest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        val mangaKey = "mangaKey"
        val imageKey = "imageKey"
        val synopsisKey = "synopsisKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewItems()
    }

    private fun setViewItems() {
        val storedSearch = SharedPreferencesManager().getSearchCriteria(this)
        if (storedSearch != null) {
            binding.searchEt.setText(storedSearch)
        }

        binding.searchBt.setOnClickListener {
            checkUserInput()
            callService()
            binding.searchBt.visibility = View.INVISIBLE
            binding.progress.visibility = View.VISIBLE
        }

        binding.favoritesBt.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }
    }

    private fun checkUserInput() {
        if (binding.searchEt.text.toString().isEmpty()) {
            Toast.makeText(this, "Veuillez effectuer une saisie", Toast.LENGTH_LONG).show()
        }
    }

    private fun callService() {
        val service: MangaApi.MangaService = MangaApi().getClient().create(MangaApi.MangaService::class.java)
        val call: Call<MangaApiResponse> = service.getMangas(binding.searchEt.text.toString())
        call.enqueue(object : Callback<MangaApiResponse> {
            override fun onResponse(call: Call<MangaApiResponse>, response: Response<MangaApiResponse>) {
                processResponse(response)
                searchEnded()
            }

            override fun onFailure(call: Call<MangaApiResponse>, t: Throwable) {
                processFailure(t)
                searchEnded()
            }
        })
    }

    private fun searchEnded() {
        binding.searchBt.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE
        SharedPreferencesManager().saveSearchCriteria(binding.searchEt.text.toString(), this)
    }

    private fun processFailure(t: Throwable) {
        Toast.makeText(this, "Erreur", Toast.LENGTH_LONG).show()
        t.message?.let { Log.d("Erreur", it) }
    }

    private fun processResponse(response: Response<MangaApiResponse>) {
        if (response.isSuccessful) {
            val body = response.body()
            if (body?.data!!.isNotEmpty()) {
                val adapter = MangaListViewAdapter(body.data, object : MangaItemCallback {
                    override fun onCellClick(data: Data) {
                        gotoNextActivity(data)
                    }

                    override fun onSaveManga(manga: Data) {
                        saveManga(manga)
                    }
                })
             //   val recyclerView = findViewById<RecyclerView>(R.id.manga_rv)
                binding.mangaRv.adapter = adapter
                binding.mangaRv.layoutManager = LinearLayoutManager(applicationContext)
            }
        } else {
            Toast.makeText(this, "Erreur lors de la récupération des données", Toast.LENGTH_LONG).show()
        }
    }

    private fun gotoNextActivity(data: Data) {
        val intent = Intent(this, MangaDetailActivity::class.java)
        intent.putExtra(mangaKey, data.title)
        intent.putExtra(imageKey, data.images?.jpg?.imageUrl)
        intent.putExtra(synopsisKey, data.synopsis)
        startActivity(intent)
    }

    private fun saveManga(manga: Data) {
        if (SharedPreferencesManager().saveManga(manga, this)){
            Toast.makeText(this,"Enregistrement bien effectué", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this,"Cette photo est déjà dans vos favoris", Toast.LENGTH_LONG).show()
        }
    }


}