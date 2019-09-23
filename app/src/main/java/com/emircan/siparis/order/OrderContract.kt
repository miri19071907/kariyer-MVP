package com.emircan.siparis.order

import com.emircan.siparis.model.Order

interface OrderContract {

    interface View {
        fun onOrderSuccess(orderList: MutableList<Order>)
        fun onOrderError(errorMessage: String)
    }

    interface Presenter {
        fun requestOrder()
    }
}