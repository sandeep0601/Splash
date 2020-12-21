package com.foamkart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.foamkart.Activitys.ProductActivity
import com.foamkart.Adapter.HomePageProductAdapter
import com.foamkart.Adapter.ViewPagerAdapter


class Home_Fragment: Fragment() {


    var images = intArrayOf(com.foamkart.R.drawable.banner1, com.foamkart.R.drawable.banner1, com.foamkart.R.drawable.banner1)
    var adapter: HomePageProductAdapter? = null
    lateinit var list:ArrayList<String>
    var linearLayoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view=inflater.inflate(com.foamkart.R.layout.fragment_home, container, false)

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

        val viewPager = view?.findViewById(com.foamkart.R.id.viewpager_slider) as ViewPager
        val mainRecycler = view?.findViewById(com.foamkart.R.id.mainRecycler) as RecyclerView
        val mainRecycler2 = view?.findViewById(com.foamkart.R.id.mainRecycler2) as RecyclerView
        val txt_more = view?.findViewById(com.foamkart.R.id.txt_more) as TextView

        txt_more.setOnClickListener {
            startActivity(Intent(context,ProductActivity::class.java))
        }
        viewPager.adapter = ViewPagerAdapter(context, images)



        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mainRecycler!!.layoutManager = linearLayoutManager
        mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = HomePageProductAdapter(list,context!!)
        mainRecycler.adapter=adapter

        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mainRecycler2!!.layoutManager = linearLayoutManager
        mainRecycler2!!.itemAnimator = DefaultItemAnimator()
        adapter = HomePageProductAdapter(list,context!!)
        mainRecycler2.adapter=adapter






        // Inflate the layout for this fragment
        return view;
    }
}