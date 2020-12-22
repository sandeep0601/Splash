package com.foamkart.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.foamkart.Adapter.ProductSliderAdapter
import com.foamkart.Adapter.ViewPagerAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivitySingleProductBinding

class ProductActivity : AppCompatActivity() {
    lateinit var binding: ActivitySingleProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_product2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_product)
        setSlider()
        binding.title.setText("iPhone 10x pro.")
        binding.imgBack.setOnClickListener { finish() }

    }
    fun setSlider() {
        var images = intArrayOf(R.drawable.mobile_image, R.drawable.mobile_image, R.drawable.mobile_image)
        binding.viewpagerSlider.adapter = ViewPagerAdapter(this, images)
    }
}