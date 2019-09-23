package com.emircan.siparis.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast


fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Context.openActivity(c: Class<*>) {
    this.startActivity(Intent(this, c))
}
