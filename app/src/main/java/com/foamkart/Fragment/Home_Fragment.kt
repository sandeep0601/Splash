package com.foamkart.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Activitys.ProductListActivity
import com.foamkart.Adapter.HomePageProductAdapter
import com.foamkart.Adapter.ViewPagerAdapter
import com.foamkart.R
import com.foamkart.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_dashboard.*


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

        list.add("Samsung Galaxy j7")
        list.add("iPhone Pro")
        list.add("Samsung Galaxy j7")
        list.add("iPhone Pro")
        list.add("Product 1")
        list.add("Product 2")
        list.add("AA")
        list.add("AA")
        list.add("AA")
        list.add("AA")

        binding.txtMore.setOnClickListener {
            startActivity(Intent(context,ProductListActivity::class.java))
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


        set_ClickListener()
        return binding.root
    }
    @SuppressLint("WrongConstant")
    fun set_ClickListener() {
        var drawer_layout: DrawerLayout=activity!!.findViewById(R.id.drawer_layout)
        binding.imgMenu.setOnClickListener {
            if(!drawer_layout.isDrawerOpen(Gravity.START)) drawer_layout.openDrawer(Gravity.START)
            else drawer_layout.closeDrawer(Gravity.END)
        }
    }
}