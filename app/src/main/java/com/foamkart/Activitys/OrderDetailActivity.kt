package com.foamkart.Activitys

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.baoyachi.stepview.VerticalStepView
import com.foamkart.Adapter.CartListAdapter
import com.foamkart.Adapter.OrderedProductAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivityOrderDetailBinding


class OrderDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderDetailBinding
    var listCart:ArrayList<String> = ArrayList()
    lateinit var mSetpview0: VerticalStepView   

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_detail)
        binding.tootbar.title.setText("Order Details")

        setCartList()
        OnClickListener()

        mSetpview0 = binding.stepView0
        val list0: MutableList<String> = ArrayList()
        list0.add("Order Placed \n21 November,2020")
        list0.add("Order Processed \n" + "21 November,2020")
        list0.add("Shipped to Us \n" + "21 November,2020")
        list0.add("Order Dispatched at VA \n" + "21 November,2020")
        list0.add("Order Delivered \n" + "21 November,2020")

        mSetpview0.setStepsViewIndicatorComplectingPosition(list0.size - 2) //设置完成的步数
            .reverseDraw(false) //default is true
            .setStepViewTexts(list0) //总步骤
            .setLinePaddingProportion(2f) //设置indicator线与线间距的比例系数
            .setLinePaddingProportion(2f)
            .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this@OrderDetailActivity,R.color.color_green)) //设置StepsViewIndicator完成线的颜色
            .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this@OrderDetailActivity, R.color.color_green)) //设置StepsViewIndicator未完成线的颜色
            .setStepViewComplectedTextColor(ContextCompat.getColor(this@OrderDetailActivity, R.color.black)) //设置StepsView text完成线的颜色
            .setStepViewUnComplectedTextColor(ContextCompat.getColor(this@OrderDetailActivity, R.color.black)) //设置StepsView text未完成线的颜色
            .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this@OrderDetailActivity, R.drawable.shape_round)) //设置StepsViewIndicator CompleteIcon
            .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this@OrderDetailActivity, R.drawable.shape_round)) //设置StepsViewIndicator DefaultIcon
            .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this@OrderDetailActivity,                 R.drawable.attention             ))
            .setTextSize(15)    //设置StepsViewIndicator AttentionIcon

    }
    fun OnClickListener() {
        binding.tootbar.imgBack.setOnClickListener { finish() }
    }
    fun setCartList() {
        listCart.add("Home")
        listCart.add("Office")
//        listCart.add("Office parking")
//        listCart.add("Punjab")

        var linearLayoutManager: LinearLayoutManager? = null
        var adapter: OrderedProductAdapter? = null

        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCart!!.layoutManager = linearLayoutManager
        binding.recyclerViewCart!!.itemAnimator = DefaultItemAnimator()
        adapter = OrderedProductAdapter(listCart, this!!)
        binding.recyclerViewCart.adapter=adapter
    }

}