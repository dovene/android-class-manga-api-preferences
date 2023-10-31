package com.example.mangaapirequest.service

import com.example.mangaapirequest.model.MangaApiResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MangaApi {
    interface MangaService {
        @GET("anime")
        fun getMangas(@Query("q") criteria: String): Call<MangaApiResponse>
    }
//https://api.jikan.moe/v4/anime?q=onepiece
    private val baseUrl = "https://api.jikan.moe/v4/"

    fun getClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}