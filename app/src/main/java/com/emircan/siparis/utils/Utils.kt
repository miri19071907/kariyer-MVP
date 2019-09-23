package com.emircan.siparis.utils

import com.emircan.siparis.OrderApplication
import com.emircan.siparis.R
import java.text.SimpleDateFormat
import java.util.*


object Utils {

    fun decimalToMonthName(month: String): String {
        val locale = Locale(OrderApplication.context.getString(R.string.language))
        val formatter = SimpleDateFormat("MMMM", locale)
        val calendar = GregorianCalendar().apply {
            set(Calendar.MONTH, month.toInt() - 1)
        }
        return formatter.format(calendar.time)
    }
}