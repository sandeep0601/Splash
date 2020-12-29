package com.foamkart.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.AddressListAdapter
import com.foamkart.Adapter.CartListAdapter
import com.foamkart.Adapter.CheckOutAddressAdapter
import com.foamkart.Adapter.HomePageProductAdapter
import com.foamkart.Custom.CustomDialog
import com.foamkart.Custom.QrDialog
import com.foamkart.R
import com.foamkart.databinding.ActivityLoginBinding
import com.foamkart.databinding.ActivityOrderCheckoutBinding
import com.foamkart.databinding.FragmentHomeBinding

class OrderCheckoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderCheckoutBinding
    var listAddress:ArrayList<String> = ArrayList()
    var listCart:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_order_checkout)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_checkout)

//        binding.btnCheckOut.setOnClickListener { startActivity(Intent(this@OrderCheckoutActivity,PaymentActivity::class.java)) }
        binding.recyclerViewAddress.isNestedScrollingEnabled = false
        binding.recyclerViewCart.isNestedScrollingEnabled = false
        setAddressList()
        setCartList()
        OnClickListener()




    }
    fun OnClickListener() {

        binding.layoutAddNewAddress.setOnClickListener {

            var operatorDialog : CustomDialog

            operatorDialog= CustomDialog(
                    this@OrderCheckoutActivity,"a"
                )
            operatorDialog.getWindow()!!.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            operatorDialog.show()

        }

    }
    fun setAddressList() {
        listAddress.add("Home")
        listAddress.add("Office")
//        listAddress.add("Office parking")
//        listAddress.add("Punjab")

        var linearLayoutManager: LinearLayoutManager? = null
        var adapter: CheckOutAddressAdapter? = null

        binding.recyclerViewAddress.isNestedScrollingEnabled = false
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewAddress!!.layoutManager = linearLayoutManager
        binding.recyclerViewAddress!!.itemAnimator = DefaultItemAnimator()
        adapter = CheckOutAddressAdapter(listAddress,this!!)
        binding.recyclerViewAddress.adapter=adapter
    }

    fun setCartList() {
        listCart.add("Home")
        listCart.add("Office")
//        listCart.add("Office parking")
//        listCart.add("Punjab")

        var linearLayoutManager: LinearLayoutManager? = null
        var adapter: CartListAdapter? = null

        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCart!!.layoutManager = linearLayoutManager
        binding.recyclerViewCart!!.itemAnimator = DefaultItemAnimator()
        adapter = CartListAdapter(listCart,this!!)
        binding.recyclerViewCart.adapter=adapter
    }
}