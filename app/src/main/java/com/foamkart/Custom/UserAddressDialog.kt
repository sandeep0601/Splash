package com.foamkart.Custom

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.foamkart.R
import com.foamkart.databinding.LayoutAddressBinding

public class UserAddressDialog : Dialog, OnItemClickListener {
    var c: Activity? = null
    var dialog_cancel_btn: ImageView? = null
    var title: TextView? = null
    var thisContext: Context? = null
    var mOperatorcode: String? = null

    constructor(thisContext: Context?, mOperatorcode: String?) : super(
        thisContext!!,
        R.style.FullWidth_Dialog
    ) {
        this.thisContext = thisContext
        this.mOperatorcode = mOperatorcode
    }

    constructor(a: Activity?) : super(a!!) {
        c = a
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(WindowManager.LayoutParams.FILL_PARENT)
        //        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.layout_address);
        val layoutParams = window!!.attributes
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window!!.attributes = layoutParams
        val binding: LayoutAddressBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_address,
            null,
            false
        )
        setContentView(binding.getRoot())
        binding.toolbar.title.setText("Add new address")
        binding.toolbar.imgBack.setOnClickListener(View.OnClickListener { dismiss() })
    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        dismiss()
    }
}