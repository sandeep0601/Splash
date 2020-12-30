package com.foamkart.Activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.Adapter.ProductSliderAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivitySingleProductBinding
import com.google.android.material.snackbar.Snackbar


class ProductActivity : AppCompatActivity() {
    lateinit var binding: ActivitySingleProductBinding
    var list:ArrayList<String> = ArrayList()
    var linearLayoutManager: LinearLayoutManager? = null
    var adapter: ProductListAdapter? = null
    var TAG="@@ProductActivity"
    var like_status=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_product2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_product)
        setSlider()
        setRelatedProductList()

        binding.title.setText("iPhone 10x pro.")
        binding.imgBack.setOnClickListener { finish() }

        binding.imgFavorite.setOnClickListener {
            var snackbar = Snackbar
                .make(it, "Selected", Snackbar.LENGTH_LONG)
            snackbar.show()

        }

        binding.imgFavorite.setOnClickListener {
            if(like_status) {
                like_status=false
                binding.imgFavorite.setImageResource(R.drawable.red_heart)
            } else {
                like_status=true
                binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }


        binding.txtBayNow.setOnClickListener {
            startActivity(Intent(this@ProductActivity,PaymentActivity::class.java))
        }

    }

    fun setSlider() {
        var images = intArrayOf(
            R.drawable.mobile_image,
            R.drawable.mobile_image,
            R.drawable.mobile_image
        )
        binding.viewpagerSlider.adapter = ProductSliderAdapter(this, images)
    }

    fun setRelatedProductList() {

        list.add("Samsung Galaxy j7")
        list.add("iPhone Pro")
        list.add("Samsung Galaxy j7")
        list.add("iPhone Pro max")
        list.add("iPhone Pro max")
        list.add("Product")
        list.add("Product")
        list.add("Product")
        list.add("Product")
        list.add("Product")
        list.add("Product")
        list.add("AA")
        list.add("AA")
        list.add("AA")
        list.add("AA")

        linearLayoutManager = GridLayoutManager(this, 3)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = ProductListAdapter(list, this@ProductActivity)
        binding.mainRecycler.adapter=adapter
    }
}