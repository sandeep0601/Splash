package com.foamkart.Activitys

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foamkart.FoamkartApp
import com.foamkart.Fragment.AccountFragment
import com.foamkart.Fragment.CartFragment
import com.foamkart.Fragment.Home_Fragment
import com.foamkart.Fragment.WishListFragment
import com.foamkart.R
import com.foamkart.databinding.ActivityDashboardBinding
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_splach_screen.*


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








        setFram(Home_Fragment(),0)
        set_ClickListener()
        bottomNavigation()


    }
    fun bottomNavigation() {
        binding.layoutHome.setOnClickListener { setFram(Home_Fragment(),0) }
        binding.layoutWishlist.setOnClickListener { setFram(WishListFragment(),1) }
        binding.layoutCart.setOnClickListener { setFram(CartFragment(),2) }
        binding.layoutAccount.setOnClickListener { setFram(AccountFragment(),3) }
    }




    @SuppressLint("WrongConstant")
    fun set_ClickListener() {

        binding.includeNavigation.layoutLogout.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
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

        binding.itemHome.setColorFilter(
            ContextCompat.getColor(this,R.color.item_color),
            PorterDuff.Mode.MULTIPLY)
        binding.itemWishList.setColorFilter(
            ContextCompat.getColor(this,R.color.item_color),
            PorterDuff.Mode.MULTIPLY)
        binding.itemCart.setColorFilter(
            ContextCompat.getColor(this,R.color.item_color),
            PorterDuff.Mode.MULTIPLY)
        binding.itemAccount.setColorFilter(
            ContextCompat.getColor(this,R.color.item_color),
            PorterDuff.Mode.MULTIPLY)

        when(bottom_nev_positiom) {
            0 -> { binding.itemHome.setColorFilter(R.color.color_green) }
            1 -> { binding.itemWishList.setColorFilter(R.color.color_green)}
            2 -> { binding.itemCart.setColorFilter(R.color.color_green) }
            3 -> { binding.itemAccount.setColorFilter(R.color.color_green) }
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