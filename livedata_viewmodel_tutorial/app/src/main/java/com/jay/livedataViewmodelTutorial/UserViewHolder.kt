package com.jay.livedataViewmodelTutorial

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val id = itemView.idd
    private val name = itemView.name
    private val button = itemView.fBtn

    fun bind(item : UserDataList){
        id.text = item.id
        name.text = item.name

        itemView.setOnClickListener {
            if(button.text == "팔로잉"){
//                MainViewModel().decrease()
                button.setBackgroundColor(Color.parseColor("#2196F3"))
                button.setTextColor(Color.parseColor("#FFFFFF"))
                button.text = "팔로우"
                button.isEnabled
            }else{
//                MainViewModel().increase()
                button.setBackgroundColor(Color.parseColor("#FFFFFF"))
                button.setTextColor(Color.parseColor("#000000"))
                button.text = "팔로잉"
            }
        }
    }

}