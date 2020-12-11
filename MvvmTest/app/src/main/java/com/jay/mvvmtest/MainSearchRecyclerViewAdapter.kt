package com.jay.mvvmtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainSearchRecyclerViewAdapter: RecyclerView.Adapter<BJViewHolder>() {

    private val list = ArrayList<String>()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BJViewHolder {
        return BJViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_broad, parent, false)
        ,parent.context
        )
    }

    override fun onBindViewHolder(holder: BJViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addImage(bid : String){
        list.add(bid)
    }
}