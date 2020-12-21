package com.foamkart.Activitys

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foamkart.FoamkartApp
import com.foamkart.Fragment.Home_Fragment
import com.foamkart.Fragment.WishListFragment
import com.foamkart.R
import com.foamkart.databinding.ActivityDashboardBinding
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity()  {
    var mSlideState=false
    lateinit var binding:ActivityDashboardBinding
    var TAG="@@"
    var FRAGMENT_OTHER = "FRAGMENT_OTHER"

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dashboard)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        binding.includeNavigation.navigationView.bringToFront()

        binding.imgMenu.setOnClickListener {
            if(!drawer_layout.isDrawerOpen(Gravity.START)) drawer_layout.openDrawer(Gravity.START)
            else drawer_layout.closeDrawer(Gravity.END)
        }









//        setFram(Home_Fragment())
        set_ClickListener()
        bottomNavigation()


    }
    fun bottomNavigation() {
        binding.layoutHome.setOnClickListener { setFram(Home_Fragment(),0) }
        binding.layoutWishlist.setOnClickListener { setFram(WishListFragment(),1) }
        binding.layoutCart.setOnClickListener { setFram(Home_Fragment(),2) }
        binding.layoutAccount.setOnClickListener { setFram(Home_Fragment(),3) }
    }

    private fun viewFragment(
            fragment: Fragment,
            name: String
    ) {
        var fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction =
                fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        // 1. Know how many fragments there are in the stack
        val count = fragmentManager.backStackEntryCount
        // 2. If the fragment is **not** "home type", save it to the stack
        if (name == FRAGMENT_OTHER) {
            fragmentTransaction.addToBackStack(name)
        }
        // Commit !
        fragmentTransaction.commit()
        // 3. After the commit, if the fragment is not an "home type" the back stack is changed, triggering the
        // OnBackStackChanged callback
        fragmentManager.addOnBackStackChangedListener(object :
                FragmentManager.OnBackStackChangedListener {
            override fun onBackStackChanged() {
                // If the stack decreases it means I clicked the back button
                if (fragmentManager.backStackEntryCount <= count) {
                    // pop all the fragment and remove the listener
                    fragmentManager.popBackStack(FRAGMENT_OTHER, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    fragmentManager.removeOnBackStackChangedListener(this)
                    // set the home button selected
//                    mainBinding.navigation.getMenu().getItem(0).setChecked(true)

                }
            }
        })
    }



    @SuppressLint("WrongConstant")
    fun set_ClickListener() {


        binding.includeNavigation.navigationView.setOnClickListener {
            if(binding.includeNavigation.navigationView.isShown) {
                drawer_layout.closeDrawer(Gravity.END)
            }
            exitDialod()
        }
    }

    fun setFram(fram: Fragment,bottom_nev_positiom:Int) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fram)
        fragmentTransaction.commit()

        binding.itemHome.setColorFilter(R.color.item_color)
        binding.itemWishList.setColorFilter(R.color.item_color)
        binding.itemCart.setColorFilter(R.color.item_color)
        binding.itemAccount.setColorFilter(R.color.item_color)

        when(bottom_nev_positiom) {
            0 -> { binding.itemHome.setColorFilter(Color.GREEN) }
            1 -> { binding.itemWishList.setColorFilter(Color.GREEN)}
            2 -> { binding.itemCart.setColorFilter(Color.GREEN) }
            3 -> { binding.itemAccount.setColorFilter(Color.GREEN) }
        }
    }
    fun exitDialod() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        val intent = Intent(FoamkartApp.myappContext, SplashScreen::class.java)
                        intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        FoamkartApp.myappContext!!.startActivity(intent) })
            .setNegativeButton("No", null)
            .show()
    }
}