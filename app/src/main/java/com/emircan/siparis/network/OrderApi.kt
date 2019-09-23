package com.emircan.siparis.network

import com.emircan.siparis.model.Order
import retrofit2.Call
import retrofit2.http.GET

interface OrderApi {

    @GET(".")
    fun getOrderList(): Call<MutableList<Order>>

}