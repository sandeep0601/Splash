package com.foamkart.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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
    var FRAGMENT_OTHER="FRAGMENT_OTHER"

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

        binding.imgSearch.setOnClickListener {
            setFram(SearchFragment(),FRAGMENT_OTHER)
        }
    }

    private fun setFram(fragment: Fragment, name: String) {
        var fram:FrameLayout= activity?.findViewById<FrameLayout>(R.id.frame_main)!!
        var fragmentManager: FragmentManager? = fragmentManager
        val fragmentTransaction =
            fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_main, fragment)
        // 1. Know how many fragments there are in the stack
        val count = fragmentManager!!.backStackEntryCount
        // 2. If the fragment is **not** "home type", save it to the stack
        if (name == FRAGMENT_OTHER) {
            fragmentTransaction!!.addToBackStack(name)
        }
        // Commit !
        fragmentTransaction!!.commit()
        // 3. After the commit, if the fragment is not an "home type" the back stack is changed, triggering the
        // OnBackStackChanged callback
        fragmentManager.addOnBackStackChangedListener(object :
            FragmentManager.OnBackStackChangedListener {
            override fun onBackStackChanged() {
                // If the stack decreases it means I clicked the back button
                if (fragmentManager.backStackEntryCount <= count) {
                    // pop all the fragment and remove the listener
                    fragmentManager.popBackStack(FRAGMENT_OTHER,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                    fragmentManager.removeOnBackStackChangedListener(this)
                    // set the home button selected
//                    mainBinding.navigation.getMenu().getItem(0).setChecked(true)
                }
            }
        })


    }
}