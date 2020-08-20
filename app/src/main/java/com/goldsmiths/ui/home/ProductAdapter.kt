package com.goldsmiths.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goldsmiths.R

class ProductAdapter(val userList: ArrayList<ProductsModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.products_infliator, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: ProductsModel) {
            val textViewName = itemView.findViewById(R.id.products_img) as ImageView
            val textViewAddress  = itemView.findViewById(R.id.products_txt) as TextView
            textViewAddress.text = user.productname
        }
    }
}