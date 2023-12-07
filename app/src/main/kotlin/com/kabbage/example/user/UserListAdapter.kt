package com.kabbage.example.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kabbage.example.R

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    var userList: List<User> = emptyList()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.user_list_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.user_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = userList[position].name
    }

    override fun getItemCount() = userList.size
}
