package com.emircan.siparis.main

import com.emircan.siparis.utils.LoginManager
import com.emircan.siparis.utils.SharedPref

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {
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
        LoginManager.login(rememberMe)
        view.successfulLogin()
    }

}