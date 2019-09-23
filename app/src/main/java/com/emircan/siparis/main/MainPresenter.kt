package com.emircan.siparis.main

import com.emircan.siparis.utils.SharedPref

class MainPresenter(private val view: MainContract.View) :
    MainContract.Presenter {
    override fun loginControl() {
        if (SharedPref.getBoolean(SharedPref.REMEMBER_ME)) {
            view.successfulLogin()
        }
    }

    override fun loginButtonClicked(username: String, password: String, rememberMe: Boolean) {
        if (username.isEmpty()) {
            view.onEmptyUsername()
            return
        }
        if (password.isEmpty()) {
            view.onEmptyPassword()
            return
        }
        if (username != "kariyer" || password != "2019ADev") {
            view.onWrongUsernameOrPassword()
            return
        }
        SharedPref.saveBoolean(SharedPref.REMEMBER_ME, rememberMe)
        view.successfulLogin()

    }


}