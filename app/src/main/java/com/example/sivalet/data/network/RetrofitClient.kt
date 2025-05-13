package com.example.sivalet.data.network

import com.example.sivalet.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.189.105:3004/" // <- Ganti Endpoint ini untuk Hit API (jika menggunakan IP sebagai endpoint nya maka di Network Security config juga di ubah menjadi IP)

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}