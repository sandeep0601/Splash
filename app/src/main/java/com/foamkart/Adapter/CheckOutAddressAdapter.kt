package com.foamkart.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.R
import kotlinx.android.synthetic.main.layout_checkout_address_adapter.view.*

class CheckOutAddressAdapter(public var product_list: ArrayList<String>, var context: Context) : RecyclerView.Adapter<CheckOutAddressAdapter.ViewHolder>() {
    lateinit var holder: ViewHolder
    private var checkedRadioButton: CompoundButton? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_checkout_address_adapter,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder=holder

        val option = getItem(position)
        holder.txt_place_name.setText(option.toString())

        holder.itemView.radioButton.setOnCheckedChangeListener(checkedChangeListener)
        if (holder.itemView.radioButton.isChecked) checkedRadioButton = holder.itemView.radioButton




    }

    private val checkedChangeListener = CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
        checkedRadioButton?.apply { setChecked(!isChecked) }
        checkedRadioButton = compoundButton.apply { setChecked(isChecked) }
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
                        Log.e("@@cart", "removeDialog: " + e.message.toString())
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
        var txt_place_name: TextView
        var txt_name: TextView
        var txt_address: TextView
        var radioButton: RadioButton


        init {
            txt_place_name = itemView.findViewById<TextView>(R.id.txt_place_name)
            txt_name = itemView.findViewById<TextView>(R.id.txt_name)
            txt_address = itemView.findViewById(R.id.txt_address)
            radioButton = itemView.findViewById(R.id.radioButton)
        }
    }
}