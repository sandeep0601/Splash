package com.foamkart.Fragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Activitys.AddressListActivity
import com.foamkart.Activitys.OrderActivity
import com.foamkart.Activitys.SplashScreen
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.Adapter.WishlistListAdapter
import com.foamkart.FoamkartApp
import com.foamkart.R
import com.foamkart.databinding.FragmentAccountBinding
import com.foamkart.databinding.FragmentWishlistBinding

class AccountFragment: Fragment() {

    lateinit var binding : FragmentAccountBinding
    lateinit var thiscontext: Context
    var list:ArrayList<String> = ArrayList()
    var TAG="@@AccountFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        var view=inflater.inflate(com.foamkart.R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        thiscontext=container!!.context


        binding.layoutLogout.setOnClickListener {
            exitDialod()
        }
        binding.layoutOrder.setOnClickListener {
            context?.startActivity(Intent(context,OrderActivity::class.java))
        }
        binding.layoutAddress.setOnClickListener {
            context?.startActivity(Intent(context, AddressListActivity::class.java))
        }




        // Inflate the layout for this fragment
        return binding.root
    }
    fun exitDialod() {
        AlertDialog.Builder(thiscontext)
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