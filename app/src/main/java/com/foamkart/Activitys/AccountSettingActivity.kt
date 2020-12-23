package com.foamkart.Activitys

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.foamkart.R
import com.foamkart.databinding.ActivityAccountSettingBinding


class AccountSettingActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_account_setting)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_account_setting)

        binding.toolbar.imgBack.setOnClickListener { finish() }
        binding.toolbar.title.text="Account Setting"



    }
}