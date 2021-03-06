package com.jay.livedataViewmodelTutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(mContext : Context, userDataList: ArrayList<UserDataList>) : RecyclerView.Adapter<UserViewHolder>() {

    private val list : ArrayList<UserDataList> = userDataList
    private val context = mContext


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.user_item, parent, false
        ))
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }


    override fun getItemCount(): Int {
        return list.size
    }



}