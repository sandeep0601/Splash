package com.foamkart.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Activitys.OrderCheckoutActivity
import com.foamkart.Adapter.CartListAdapter
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.Adapter.WishlistListAdapter
import com.foamkart.R
import com.foamkart.databinding.FragmentCartBinding
import com.foamkart.databinding.FragmentWishlistBinding

class CartFragment: Fragment() {

    var adapter: CartListAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    lateinit var binding : FragmentCartBinding
    lateinit var thiscontext: Context
    var list:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        var view=inflater.inflate(com.foamkart.R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        thiscontext=container!!.context

        binding.toolbar.txtTitle.setText("My Cart")
        binding.txtCheckOut.setOnClickListener {
            startActivity(Intent(thiscontext, OrderCheckoutActivity::class.java))
        }
        setList()

        return binding.root
    }
    fun setList() {
        list= ArrayList()

        list.add("Samsung Galaxy j7")
        list.add("Samsung Galaxy j7 pro")
        list.add("Samsung Galaxy j7 pro")

        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = null
        adapter = CartListAdapter(list, thiscontext)
        binding.mainRecycler.adapter=adapter
    }
}
