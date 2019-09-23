package com.emircan.siparis.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private const val BASE_URL = "http://kariyertechchallenge.mockable.io/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            client(OkHttpClient())
        }.build()
    }

    fun getOrderApi(): OrderApi {
        return getRetrofit()
            .create(OrderApi::class.java)
    }
}