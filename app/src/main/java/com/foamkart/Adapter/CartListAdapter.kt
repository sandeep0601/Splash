package com.foamkart.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.R
import java.lang.Exception

class CartListAdapter(public var product_list: ArrayList<String>, var context: Context) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    lateinit var holder: ViewHolder




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_cartlist_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder=holder

        val option = getItem(position)
        holder.product_name.setText(option.toString())

        holder.img_delet.setOnClickListener {
            if (holder.img_delet.drawable.constantState == ContextCompat.getDrawable(context, R.drawable.ic_baseline_favorite_border_24)!!.constantState)
            {
                holder.img_delet.setImageResource(R.drawable.ic_baseline_favorite_border_redcolor)
            } else {
                removeDialog(position)
            }
        }

        holder.img_plus.setOnClickListener {
//            holder.txt_quantity.setText((holder.txt_quantity.text.toString().trim().toInt()+1).toString())



            var qu= (holder.txt_quantity.text.toString().trim().toInt()+1).toString()
            holder.txt_quantity.setText(qu.toString())
            holder.txt_quntity2.setText(qu.toString())

            holder.txt_price.setText((holder.txt_single_product_amt.text.toString().trim().toInt() * 2).toString())
        }

        holder.img_minus.setOnClickListener {
            if(holder.txt_quantity.text.toString().trim().toInt()>0) {

                var qu= (holder.txt_quantity.text.toString().trim().toInt()-1).toString()
                holder.txt_quantity.setText(qu.toString())
                holder.txt_quntity2.setText(qu.toString())

                holder.txt_price.setText((holder.txt_single_product_amt.text.toString().trim().toInt() * holder.txt_quntity2.text.toString().trim().toInt()).toString())
            } else {
            }
        }




    }



    fun removeDialog(position: Int) {
        AlertDialog.Builder(context)
            .setMessage("Are you sure you want to remove?")
            .setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog, id ->

                    try {
                        remove(position)
                    } catch (e: Exception) {
                        Log.e("@@cart", "removeDialog: "+e.message.toString())
                    }
                })
            .setNegativeButton("No", null)
            .show()
    }
    fun remove(position: Int) {
        if (product_list.size < 0) {
            product_list.clear()
        } else {
            product_list.remove(product_list.get(position))
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, itemCount)
        }
    }





    private fun getItem(index: Int): String {
        return product_list[index]
    }

    override fun getItemCount(): Int {
        return product_list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var product_name: TextView
        var txt_des: TextView
        var txt_quantity: TextView
        var txt_price: TextView
        var txt_quntity2: TextView
        var img_delet: ImageView
        var img_plus: ImageView
        var img_minus: ImageView
        var txt_single_product_amt: TextView


        init {
            product_name = itemView.findViewById<TextView>(R.id.product_name)
            txt_des = itemView.findViewById<TextView>(R.id.txt_des)
            img_delet = itemView.findViewById(R.id.img_delet)
            img_plus = itemView.findViewById(R.id.img_plus)
            img_minus = itemView.findViewById(R.id.img_minus)
            txt_quantity = itemView.findViewById(R.id.txt_quantity)
            txt_price = itemView.findViewById(R.id.txt_price)
            txt_single_product_amt = itemView.findViewById(R.id.txt_single_product_amt)
            txt_quntity2 = itemView.findViewById(R.id.txt_quntity2)
            itemView.setOnClickListener {
            }
        }
    }
}