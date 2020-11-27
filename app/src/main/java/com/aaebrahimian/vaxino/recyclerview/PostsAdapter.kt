package com.aaebrahimian.vaxino.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.item_1.view.*


class PostsAdapter (private val datalist : MutableList<Post_Model>): RecyclerView.Adapter<MyHolder>(){
    private lateinit var context : Context
    override fun getItemCount(): Int = datalist.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_1, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = datalist[position]

        val txt_title = holder.itemView.txt_Title
        val txt_body = holder.itemView.txt_Body
        val img_Item = holder.itemView.img_Item
    }
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder (itemView) {
    }

}