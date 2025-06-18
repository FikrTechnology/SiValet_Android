package com.example.sivalet.data.network

import com.example.sivalet.data.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://IP_HERE/" // <- Ganti Endpoint ini untuk Hit API (jika menggunakan IP sebagai endpoint nya maka di Network Security config juga di ubah menjadi IP)

    var tokenProvider: () -> String? = { null } // Provider untuk token yang akan digunakan di interceptor

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain: Interceptor.Chain ->
            val token = tokenProvider()
            val request: Request = chain.request().newBuilder().apply {
                if (!token.isNullOrEmpty()) {
                    addHeader("Authorization", "Bearer $token")
                }
            }.build()
            chain.proceed(request)
        }
        .build()

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}