package com.foamkart.Fragment

import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.foamkart.Adapter.ProductListAdapter
import com.foamkart.R
import com.foamkart.databinding.ActivitySearchFragmentBinding


class SearchFragment : Fragment() {

    var linearLayoutManager: LinearLayoutManager? = null
    lateinit var binding : ActivitySearchFragmentBinding
    lateinit var thiscontext: Context
    var list:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_search_fragment, container, false)
        thiscontext=container!!.context

        createTopDownAnimation(binding.searchView, null, 100F)?.start()



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                setList()
                binding.txtMess.visibility=View.GONE
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })


        // Inflate the layout for this fragment
        return binding.root
    }
    fun setList() {

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

        var adapter: ProductListAdapter? = null
        linearLayoutManager = GridLayoutManager(thiscontext, 2)
        binding.mainRecycler!!.layoutManager = linearLayoutManager
        binding.mainRecycler!!.itemAnimator = DefaultItemAnimator()
        adapter = ProductListAdapter(list, thiscontext)
        binding.mainRecycler.adapter=adapter
    }
    private fun createBottomUpAnimation(
        view: View,
        listener: AnimatorListenerAdapter?, distance: Float
    ): ObjectAnimator? {
        val animator = ObjectAnimator.ofFloat(view, "translationY", -distance)
        //        animator.setDuration(???)
        animator.removeAllListeners()
        if (listener != null) {
            animator.addListener(listener)
        }
        return animator
    }
    fun createTopDownAnimation(view: View, listener: AnimatorListenerAdapter?, distance: Float): ObjectAnimator? {
        view.translationY = -distance
        val animator = ObjectAnimator.ofFloat(view, "translationY", 0f)
        animator.removeAllListeners()
        if (listener != null) {
            animator.addListener(listener)
        }
        return animator
    }
}