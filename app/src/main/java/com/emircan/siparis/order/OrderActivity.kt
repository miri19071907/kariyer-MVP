package com.emircan.siparis.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.emircan.siparis.R
import com.emircan.siparis.main.LoginActivity
import com.emircan.siparis.model.Order
import com.emircan.siparis.utils.openActivity
import com.emircan.siparis.utils.showToast
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity(), OrderContract.View {
    private lateinit var orderPresenter : OrderPresenter

    override fun onLogOut() {
        openActivity(LoginActivity::class.java)
        finish()
    }

    override fun onOrderSuccess(orderList: MutableList<Order>) {
        val orderAdapter = OrderAdapter(this, orderList)
        rvOrders.apply {
            layoutManager = LinearLayoutManager(this@OrderActivity)
            adapter = orderAdapter
        }
    }

    override fun onOrderError(errorMessage: String) {
        showToast(errorMessage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        orderPresenter = OrderPresenter(this)

        orderPresenter.requestOrder()

        cvLogOut.setOnClickListener {
            orderPresenter.logOut()
        }
    }
}
