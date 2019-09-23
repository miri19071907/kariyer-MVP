package com.emircan.siparis.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.emircan.siparis.R
import com.emircan.siparis.base.BaseActivity
import com.emircan.siparis.main.LoginActivity
import com.emircan.siparis.model.Order
import com.emircan.siparis.utils.Utils
import com.emircan.siparis.utils.openActivity
import com.emircan.siparis.utils.showToast
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : BaseActivity(), OrderContract.View {
    override fun getLayoutId(): Int = R.layout.activity_order

    private lateinit var orderPresenter : OrderPresenter

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
        orderPresenter = OrderPresenter(this)

        orderPresenter.requestOrder()

        cvLogOut.setOnClickListener {
            Utils.showLogoutDialog(this@OrderActivity)
        }
    }
}
