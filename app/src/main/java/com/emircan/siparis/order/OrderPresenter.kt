package com.emircan.siparis.order

import com.emircan.siparis.network.NetworkManager
import com.emircan.siparis.model.Order
import com.emircan.siparis.utils.LoginManager
import com.emircan.siparis.utils.SharedPref
import com.emircan.siparis.utils.SharedPref.REMEMBER_ME
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderPresenter(val view: OrderContract.View) : OrderContract.Presenter {

    override fun requestOrder() {
        NetworkManager.getOrderApi().getOrderList().enqueue(object : Callback<MutableList<Order>> {
            override fun onFailure(call: Call<MutableList<Order>>, t: Throwable) {
                t.message?.let { view.onOrderError(it) }
            }

            override fun onResponse(call: Call<MutableList<Order>>, response: Response<MutableList<Order>>) {
                if (!response.isSuccessful) {
                    view.onOrderError("Hata")
                    return
                }
                when {
                    response.body() == null -> view.onOrderError("null body")
                    response.body()!!.size == 0 -> view.onOrderError("boş liste")
                    else -> view.onOrderSuccess(response.body()!!)
                }

            }

        })

    }
}