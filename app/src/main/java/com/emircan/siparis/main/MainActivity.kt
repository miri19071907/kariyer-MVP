package com.emircan.siparis.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emircan.siparis.R
import com.emircan.siparis.order.OrderActivity
import com.emircan.siparis.utils.openActivity
import com.emircan.siparis.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun successfulLogin() {
        finish()
        openActivity(OrderActivity::class.java)
    }

    override fun onEmptyPassword() {
        showToast(getString(R.string.blank_password))
    }

    override fun onEmptyUsername() {
        showToast(getString(R.string.blank_username))
    }

    override fun onWrongUsernameOrPassword() {
        showToast(getString(R.string.wrong_password_or_username))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = MainPresenter(this)

        presenter.loginControl()

        btnLogin.setOnClickListener {
            presenter.loginButtonClicked(
                etUsername.text.toString(),
                etPassword.text.toString(),
                switchRememberMe.isChecked
            )
        }
    }
}
