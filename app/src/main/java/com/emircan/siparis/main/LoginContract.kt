package com.emircan.siparis.main

interface LoginContract {
    interface View {
        fun onEmptyPassword()
        fun onEmptyUsername()
        fun onWrongUsernameOrPassword()
        fun successfulLogin()
    }

    interface Presenter {
        fun loginButtonClicked(username: String, password: String, rememberMe: Boolean)
        fun loginControl()
    }
}