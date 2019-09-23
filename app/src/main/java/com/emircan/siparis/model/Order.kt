package com.emircan.siparis.model

data class Order(
    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: String,
    val productState: String,
    var showDetail: Boolean,
    val productDetail: ProductDetail
)