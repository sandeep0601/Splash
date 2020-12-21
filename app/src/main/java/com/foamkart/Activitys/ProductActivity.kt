package com.foamkart.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.R


class ProductActivity : AppCompatActivity() {
    lateinit var list:ArrayList<String>
    var linearLayoutManager: LinearLayoutManager? = null
    var adapter: ProductListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val mainRecycler = findViewById(R.id.mainRecycler) as RecyclerView

        list= ArrayList()

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
        mainRecycler!!.layoutManager = linearLayoutManager
        mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = ProductListAdapter(list, this@ProductActivity)
        mainRecycler.adapter=adapter

    }
}