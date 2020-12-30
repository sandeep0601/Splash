package com.foamkart.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.Activitys.OrderDetailActivity
import com.foamkart.R

class OrderListAdapter(private var mOptionList: List<String>, var context: Context) : RecyclerView.Adapter<OrderListAdapter.ViewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_order_list_adapter, parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = getItem(position)
        holder.product_name.setText(option.toString())
        holder.txt_date_and_time.text = "Ordered on 10/10/2020 12:50 PM"
        holder.txt_status.text = "Cancelled"
        holder.item.setOnClickListener {
            context.startActivity(Intent(context,OrderDetailActivity::class.java))
        }
    }

    private fun getItem(index: Int): String {
        return mOptionList[index]
    }

    override fun getItemCount(): Int {
        return mOptionList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var product_name: TextView
        var txt_date_and_time: TextView
        var txt_status: TextView
        var item: CardView


        init {
            product_name = itemView.findViewById<TextView>(R.id.product_name)
            txt_date_and_time = itemView.findViewById<TextView>(R.id.txt_date_and_time)
            txt_status = itemView.findViewById<TextView>(R.id.txt_status)
            item = itemView.findViewById(R.id.item)

        }
    }
}