package com.foamkart.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivityProductlistBinding


class ProductListActivity : AppCompatActivity() {
    var list:ArrayList<String> = ArrayList()
    var linearLayoutManager: LinearLayoutManager? = null
    var adapter: ProductListAdapter? = null
    lateinit var binding: ActivityProductlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_product)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_productlist)

        binding.imgBack.setOnClickListener { finish() }

        setList()


    }
    fun setList() {
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

        linearLayoutManager = GridLayoutManager(this, 2)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = ProductListAdapter(list, this@ProductListActivity)
        binding.mainRecycler.adapter=adapter
    }
}