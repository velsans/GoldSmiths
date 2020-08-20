package com.goldsmiths.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.goldsmiths.R

class HomeFragment : Fragment(), LifecycleOwner {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {
        //textView.text = it
        //})
        val product_recyclerView = root.findViewById(R.id.products_RV) as RecyclerView
        product_recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        val users = ArrayList<ProductsModel>()
        //adding some dummy data to the list
        users.add(ProductsModel("Ring", "Bangalore Karnataka"))
        users.add(ProductsModel("Bracelet", "Bangalore Karnataka"))
        users.add(ProductsModel("Chain", "Bangalore Karnataka"))
        users.add(ProductsModel("Thodu", "Bangalore Karnataka"))
        users.add(ProductsModel("Ring", "Bangalore Karnataka"))
        users.add(ProductsModel("Bracelet", "Bangalore Karnataka"))
        users.add(ProductsModel("Chain", "Bangalore Karnataka"))
        users.add(ProductsModel("Thodu", "Bangalore Karnataka"))
        //creating our adapter
        val product_adapter = ProductAdapter(users)
        product_recyclerView.adapter = product_adapter

        val collections_recyclerView = root.findViewById(R.id.collections_RV) as RecyclerView
        collections_recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        val collections_adapter = CollectionsAdapter(users)
        collections_recyclerView.adapter = collections_adapter

        return root
    }

}