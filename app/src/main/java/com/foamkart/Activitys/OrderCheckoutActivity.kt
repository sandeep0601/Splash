package com.foamkart.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.foamkart.R
import com.foamkart.databinding.ActivityLoginBinding
import com.foamkart.databinding.ActivityOrderCheckoutBinding

class OrderCheckoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderCheckoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_order_checkout)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_checkout)

        binding.btnCheckOut.setOnClickListener { startActivity(Intent(this@OrderCheckoutActivity,PaymentActivity::class.java)) }
    }
}