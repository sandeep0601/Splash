package com.foamkart.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.OrderListAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    lateinit var binding: ActivityOrderBinding
    var list:ArrayList<String> = ArrayList()
    var linearLayoutManager: LinearLayoutManager? = null
    var adapter: OrderListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_order)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order)
        binding.toolbar.title.setText("My Orders")

        setList()
        set_ClickListener()



    }
    fun set_ClickListener() {

        binding.toolbar.imgBack.setOnClickListener { finish() }
    }

    fun setList() {

        list.add("Samsung Galaxy j7")
        list.add("iPhone Pro")
        list.add("Samsung Galaxy j7")
        list.add("iPhone Pro max")

        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = OrderListAdapter(list, this@OrderActivity)
        binding.mainRecycler.adapter=adapter
    }
}