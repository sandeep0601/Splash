package com.foamkart.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.R

class HomePageProductAdapter(private var mOptionList: List<String>, var context: Context) : RecyclerView.Adapter<HomePageProductAdapter.ViewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_page_product_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = getItem(position)
        holder.product_name.setText(option.toString())

    }



    private fun getItem(index: Int): String {
        return mOptionList[index]
    }

    override fun getItemCount(): Int {
        return mOptionList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var product_name: TextView


        init {
            product_name = itemView.findViewById<TextView>(R.id.product_name)
            itemView.setOnClickListener {
               /* if (mOnItemClickListener != null) {
                    mOnItemClickListener!!.onItemClick(getItem(adapterPosition))
                }*/
            }
        }
    }
}