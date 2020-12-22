package com.foamkart.Activitys

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.foamkart.Adapter.ViewPagerAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivitySingleProductBinding
import com.google.android.material.snackbar.Snackbar


class ProductActivity : AppCompatActivity() {
    lateinit var binding: ActivitySingleProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_product2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_product)
        setSlider()
        binding.title.setText("iPhone 10x pro.")
        binding.imgBack.setOnClickListener { finish() }


        binding.imgFavorite.setOnClickListener {
            var snackbar = Snackbar
                .make(it, "Selected", Snackbar.LENGTH_LONG)
            snackbar.show()
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_redcolor)

  /*          snackBar.setActionTextColor(Color.BLUE)
            val snackBarView: View = snackBar.getView()
            val textView: TextView =
                snackBarView.findViewById(android.support.design.R.id.snackbar_text)
            textView.setTextColor(Color.RED)
            snackBar.show()*/

        }

    }
    fun setSlider() {
        var images = intArrayOf(
            R.drawable.mobile_image,
            R.drawable.mobile_image,
            R.drawable.mobile_image
        )
        binding.viewpagerSlider.adapter = ViewPagerAdapter(this, images)
    }
}