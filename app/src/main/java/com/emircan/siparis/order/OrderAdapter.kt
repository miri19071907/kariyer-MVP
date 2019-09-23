package com.emircan.siparis.order

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emircan.siparis.R
import com.emircan.siparis.model.Order
import kotlinx.android.synthetic.main.item_order.view.*
import kotlinx.android.synthetic.main.item_product_detail.view.*

class OrderAdapter(private val context: Context, private val orderList: MutableList<Order>) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_order, parent, false))
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = orderList[position]
        holder.itemView.apply {
            tvMarketName.text = order.marketName
            tvDay.text = order.date
            tvPrice.text = order.productPrice
            tvOrderName.text = order.orderName
            tvMonth.text = order.month
            containerProductDetail.apply {
                visibility = if (order.showDetail) VISIBLE else GONE
                tvProductName.text = order.productDetail.orderDetail
                tvProductPrice.text = order.productDetail.summaryPrice
            }
            tvProductState.apply {
                text = order.productState
                setTextColor(
                    when (order.productState) {
                        "Hazırlanıyor" -> Color.MAGENTA
                        "Yolda" -> Color.RED
                        "Onay Bekliyor" -> Color.GREEN
                        else -> Color.BLACK
                    }
                )
            }
        }
        holder.itemView.setOnClickListener {
            order.showDetail = !order.showDetail
            notifyItemChanged(position)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}