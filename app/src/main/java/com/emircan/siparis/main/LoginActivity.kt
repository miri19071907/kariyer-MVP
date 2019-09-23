package com.emircan.siparis.main

import android.os.Bundle
import com.emircan.siparis.R
import com.emircan.siparis.base.BaseActivity
import com.emircan.siparis.order.OrderActivity
import com.emircan.siparis.utils.openActivity
import com.emircan.siparis.utils.showToast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    override fun getLayoutId(): Int = R.layout.activity_login

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

        val presenter = LoginPresenter(this)

        presenter.loginControl()
        presenter.loginControl()
        presenter.loginControl()
        presenter.loginControl()

        cvLogin.setOnClickListener {
            presenter.loginButtonClicked(
                etUsername.text.toString(),
                etPassword.text.toString(),
                switchRememberMe.isChecked
            )
        }
    }
}
