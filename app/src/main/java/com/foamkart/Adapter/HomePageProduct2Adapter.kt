package com.foamkart.Adapter

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.Activitys.ProductActivity
import com.foamkart.R
import kotlinx.android.synthetic.main.view_search.view.*

class HomePageProduct2Adapter(private var mOptionList: List<String>, var context: Context) : RecyclerView.Adapter<HomePageProduct2Adapter.ViewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_page_product2_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = getItem(position)
        holder.product_name.setText(option.toString())

        holder.item.setOnClickListener {
            context.startActivity(Intent(context, ProductActivity::class.java))
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
        var txt_description: TextView
        var txt_price: TextView
        var item: CardView


        init {
            product_name = itemView.findViewById<TextView>(R.id.product_name)
            txt_description = itemView.findViewById<TextView>(R.id.txt_description)
            txt_price = itemView.findViewById<TextView>(R.id.txt_price)
            item = itemView.findViewById<CardView>(R.id.item)

        }
    }

}