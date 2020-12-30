package com.foamkart.Custom

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.foamkart.Helper.ImageUtils
import com.foamkart.R
import com.foamkart.databinding.LayoutUpdateProfileBinding
import java.io.File

class ProfileUpdateDialog(context: Context?, var ac: Activity?) : Dialog(context!!, R.style.FullWidth_Dialog), OnItemClickListener , ImageUtils.ImageAttachmentListener {
    var c: Activity? = null
    var dialog_cancel_btn: ImageView? = null
    var title: TextView? = null

    private var bitmap: Bitmap? = null
    private var file_name: String? = null
    private var imageutils: ImageUtils? = null
    var binding:LayoutUpdateProfileBinding?=null


    /*init {
        this.thisContext = thisContext
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(WindowManager.LayoutParams.FILL_PARENT)
        val layoutParams = window!!.attributes
        window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        window!!.attributes = layoutParams

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_update_profile, null, false)
        setContentView(binding!!.root)
        //
        imageutils = ImageUtils(ac)

        binding!!.toolbar.title.text = "Profile Update"
        binding!!.toolbar.imgBack.setOnClickListener { dismiss() }
        binding!!.txtEditPhoto!!.setOnClickListener { imageutils!!.imagepicker(1) }


    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        dismiss()
    }

    override fun image_attachment(from: Int, filename: String?, file: Bitmap?, uri: Uri?) {
        bitmap = file
        file_name = filename
        binding!!.imgUserImage.setImageBitmap(file)
        val path = Environment.getExternalStorageDirectory()
            .toString() + File.separator + "ImagePicker" + File.separator
        imageutils!!.createImage(file, filename, path, false)
        binding?.imgUserImage?.setImageBitmap(bitmap)

    }

}