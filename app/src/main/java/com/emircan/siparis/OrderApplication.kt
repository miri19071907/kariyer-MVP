package com.emircan.siparis

import android.app.Application
import android.content.Context

class OrderApplication : Application() {


    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}