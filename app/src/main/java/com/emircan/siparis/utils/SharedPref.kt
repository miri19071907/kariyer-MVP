package com.emircan.siparis.utils

import android.content.Context
import android.content.SharedPreferences
import com.emircan.siparis.OrderApplication.Companion.context

object SharedPref {

    const val REMEMBER_ME = "remember_me"

    private val sharedPreferences = context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)

    fun saveBoolean(key: String, value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}