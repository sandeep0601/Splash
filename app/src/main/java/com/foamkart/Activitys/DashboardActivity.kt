package com.foamkart.Activitys

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foamkart.Home_Fragment
import com.foamkart.R
import com.foamkart.databinding.ActivityDashboardBinding
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity() {
    var mSlideState=false
    lateinit var binding:ActivityDashboardBinding
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
       /* img_menu.setOnClickListener {
            if(!drawer_layout.isDrawerOpen(Gravity.START)) drawer_layout.openDrawer(Gravity.START);
            else drawer_layout.closeDrawer(Gravity.END);
        }*/

        binding.imgMenu.setOnClickListener {
            if(!drawer_layout.isDrawerOpen(Gravity.START)) drawer_layout.openDrawer(Gravity.START)
            else drawer_layout.closeDrawer(Gravity.END)
        }

        setFram(Home_Fragment())




    }



    fun setFram(fram: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fram)
        fragmentTransaction.commit()
    }




}