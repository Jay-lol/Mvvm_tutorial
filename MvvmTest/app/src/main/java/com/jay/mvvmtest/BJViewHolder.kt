package com.jay.mvvmtest

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_broad.view.*

class BJViewHolder(itemView: View, var context: Context) : RecyclerView.ViewHolder(itemView) {

    private val imgView = itemView.thm

    fun bind(bid : String){
        Glide.with(context).load(bid)
            .into(imgView)
    }
}