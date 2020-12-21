package com.foamkart.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.HomePageProductAdapter
import com.foamkart.R
import com.foamkart.databinding.FragmentHomeBinding
import com.foamkart.databinding.FragmentWidhlistBinding

class WishListFragment: Fragment() {

    var images = intArrayOf(com.foamkart.R.drawable.banner1, com.foamkart.R.drawable.banner1, com.foamkart.R.drawable.banner1)
    var adapter: HomePageProductAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    lateinit var binding : FragmentWidhlistBinding
    lateinit var thiscontext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        var view=inflater.inflate(com.foamkart.R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_widhlist, container, false)
        thiscontext=container!!.context





        // Inflate the layout for this fragment
        return binding.root
    }
}