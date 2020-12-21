package com.foamkart.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.foamkart.Activitys.ProductActivity
import com.foamkart.Adapter.HomePageProductAdapter
import com.foamkart.Adapter.ViewPagerAdapter
import com.foamkart.R
import com.foamkart.databinding.FragmentHomeBinding


class Home_Fragment: Fragment() {


    var images = intArrayOf(R.drawable.banner1, R.drawable.banner1, R.drawable.banner1)
    var adapter: HomePageProductAdapter? = null
    lateinit var list:ArrayList<String>
    var linearLayoutManager: LinearLayoutManager? = null
    lateinit var binding : FragmentHomeBinding
    lateinit var thiscontext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

//        var view=inflater.inflate(R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        thiscontext=container!!.context
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



        binding.txtMore.setOnClickListener {
            startActivity(Intent(context,ProductActivity::class.java))
        }
        binding.viewpagerSlider.adapter = ViewPagerAdapter(context, images)



        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = HomePageProductAdapter(list,context!!)
        binding.mainRecycler.adapter=adapter

        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainRecycler2!!.layoutManager = linearLayoutManager
        binding.mainRecycler2!!.itemAnimator = DefaultItemAnimator()
        adapter = HomePageProductAdapter(list,context!!)
        binding.mainRecycler2.adapter=adapter






        // Inflate the layout for this fragment
        return binding.root
    }
}