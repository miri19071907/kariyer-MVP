package com.emircan.siparis.order

import com.emircan.siparis.model.Order

interface OrderContract {

    interface View {
        fun onOrderSuccess(orderList: MutableList<Order>)
        fun onOrderError(errorMessage: String)
        fun onLogOut()
    }

    interface Presenter {
        fun requestOrder()
        fun logOut()
    }
}