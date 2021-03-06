package com.foamkart.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.Activitys.DashboardActivity
import com.foamkart.Activitys.ProductActivity
import com.foamkart.R

class WishlistListAdapter(public var product_list: ArrayList<String>, var context: Context) : RecyclerView.Adapter<WishlistListAdapter.ViewHolder>() {
    lateinit var holder: ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_wishlist_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder=holder

        val option = getItem(position)
        holder.product_name.setText(option.toString())

        holder.img_favret.setOnClickListener {
            if (holder.img_favret.drawable.constantState == ContextCompat.getDrawable(context, R.drawable.ic_baseline_favorite_border_24)!!.constantState)
            {
                holder.img_favret.setImageResource(R.drawable.ic_baseline_favorite_border_redcolor)
            } else {
                removeDialog(position)
            }
        }
        holder.item.setOnClickListener { context.startActivity(Intent(context, ProductActivity::class.java)) }

    }

    fun removeDialog(position: Int) {
        AlertDialog.Builder(context)
            .setMessage("Are you sure you want to remove?")
            .setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog, id ->
//                    product_list.remove(position)
//                    notifyItemRemoved(position)
                    remove(position)

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
        var img_favret: ImageView
        var item: CardView
//prinka

        init {
            product_name = itemView.findViewById<TextView>(R.id.product_name)
            img_favret = itemView.findViewById(R.id.img_favret)
            item = itemView.findViewById(R.id.item)

        }
    }
}