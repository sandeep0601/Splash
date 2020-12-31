package com.foamkart.Custom

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.foamkart.Activitys.DashboardActivity
import com.foamkart.R
import com.foamkart.databinding.LayoutUpdateProfileBinding

class ProfileUpdateDialog(var thiscontext: Context?, var ac: Activity?) : Dialog(thiscontext!!, R.style.FullWidth_Dialog), OnItemClickListener {

    var title: TextView? = null
    var binding:LayoutUpdateProfileBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(WindowManager.LayoutParams.FILL_PARENT)
        val layoutParams = window!!.attributes
        window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        window!!.attributes = layoutParams

        binding = DataBindingUtil.inflate(LayoutInflater.from(thiscontext), R.layout.layout_update_profile, null, false)
        setContentView(binding!!.root)

        binding!!.toolbar.title.text = "Profile Update"
        binding!!.toolbar.imgBack.setOnClickListener { dismiss() }

        binding!!.txtEditPhoto!!.setOnClickListener {
//            dismiss()
            showImageOptionDialog()
        }


    }


    fun showImageOptionDialog() {
        val options = context.resources.getStringArray(R.array.image_options)
        val builder = AlertDialog.Builder(thiscontext)
        builder.setTitle("dialog_image_options")
                .setItems(options, DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        0 -> getImageFromGallery()
//                        1 -> capturePictureFromCamera()
                    }
                })
        val dialog = builder.create()
        dialog.show()
    }
    fun getImageFromGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        ac?.startActivityForResult(intent, 101)
    }

    fun setImage(selectedImage: Uri) {
        binding!!.imgUserImage.setImageURI(selectedImage)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }
}