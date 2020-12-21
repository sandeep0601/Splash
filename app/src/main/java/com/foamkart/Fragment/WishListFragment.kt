package com.foamkart.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.Adapter.WishlistListAdapter
import com.foamkart.R
import com.foamkart.databinding.FragmentWishlistBinding

class WishListFragment: Fragment() {

    var images = intArrayOf(com.foamkart.R.drawable.banner1, com.foamkart.R.drawable.banner1, com.foamkart.R.drawable.banner1)
    var adapter: WishlistListAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    lateinit var binding : FragmentWishlistBinding
    lateinit var thiscontext: Context
    var list:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        var view=inflater.inflate(com.foamkart.R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wishlist, container, false)
        thiscontext=container!!.context


        setList()



        // Inflate the layout for this fragment
        return binding.root
    }
    fun setList() {
        list= ArrayList()

        list.add("Product")
        list.add("Product")

        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = WishlistListAdapter(list, thiscontext)
        binding.mainRecycler.adapter=adapter
    }
}