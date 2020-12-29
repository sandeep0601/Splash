package com.foamkart.Custom

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.foamkart.R

class QrDialog(var activity: Activity?):Dialog(activity!!) {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_address)

        val layoutParams = window!!.attributes
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window!!.attributes = layoutParams
        setCancelable(false)
//        var img_qrcode: ImageView? =findViewById<ImageView>(R.id.img_qrcode)
        var img_close: ImageView? =findViewById<ImageView>(R.id.img_back)
        var txt_name: TextView? =findViewById<TextView>(R.id.txt_name)
        img_close?.setOnClickListener { dismiss() }






    }

    override fun onStart() {

        super.onStart()
    }



}