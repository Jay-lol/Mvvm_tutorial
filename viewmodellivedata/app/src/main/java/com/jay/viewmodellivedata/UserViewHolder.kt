package com.jay.viewmodellivedata

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*

class UserViewHolder(itemView: View, mainmodel: MainViewModel) : RecyclerView.ViewHolder(itemView) {

    private val id = itemView.idd
    private val name = itemView.name
    private val button = itemView.fBtn
    private val mainModel = mainmodel
    fun bind(item: UserDataList) {
        id.text = item.id
        name.text = item.name

        if (item.isFollow) {
            button.setBackgroundColor(Color.parseColor("#FFFFFF"))
            button.setTextColor(Color.parseColor("#000000"))
        } else {
            button.setBackgroundColor(Color.parseColor("#2196F3"))
            button.setTextColor(Color.parseColor("#FFFFFF"))
        }

        button.setOnClickListener {
            if (item.isFollow) {
                mainModel.decrease()
                button.setBackgroundColor(Color.parseColor("#2196F3"))
                button.setTextColor(Color.parseColor("#FFFFFF"))
                button.text = "팔로우"
                button.isEnabled
                item.isFollow = false
            } else {
                mainModel.increase()
                button.setBackgroundColor(Color.parseColor("#FFFFFF"))
                button.setTextColor(Color.parseColor("#000000"))
                button.text = "팔로잉"
                item.isFollow = true
            }
        }
    }

}