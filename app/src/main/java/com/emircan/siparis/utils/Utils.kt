package com.emircan.siparis.utils

import android.app.Dialog
import android.view.Window
import com.emircan.siparis.OrderApplication
import com.emircan.siparis.R
import com.emircan.siparis.base.BaseActivity
import kotlinx.android.synthetic.main.dialog_logout.*
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent
import com.emircan.siparis.main.LoginActivity


object Utils {

    fun decimalToMonthName(month: String): String {
        val locale = Locale(OrderApplication.context.getString(R.string.language))
        val formatter = SimpleDateFormat("MMMM", locale)
        val calendar = GregorianCalendar().apply {
            set(Calendar.MONTH, month.toInt() - 1)
        }
        return formatter.format(calendar.time)
    }

    fun showLogoutDialog(baseActivity: BaseActivity) {
        Dialog(baseActivity).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(false)
            setContentView(R.layout.dialog_logout)
            cvCancel.setOnClickListener {
                dismiss()
            }
            cvLogout.setOnClickListener {
                LoginManager.logOut()
                val intent = Intent(baseActivity, LoginActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                baseActivity.startActivity(intent)
            }
        }.show()
    }


}