package com.emircan.siparis.utils

object LoginManager {

    fun login(rememberMe: Boolean) {
        SharedPref.saveBoolean(SharedPref.REMEMBER_ME, rememberMe)
    }

    fun logOut() {
        SharedPref.saveBoolean(SharedPref.REMEMBER_ME, false)
    }
}