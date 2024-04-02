package com.amitwc.oloistachat.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.amitwc.oloistachat.R
import com.amitwc.oloistachat.activity.ChatActivity
import com.amitwc.oloistachat.databinding.ChatUserItemLayoutBinding
import com.amitwc.oloistachat.model.UserModel
import com.bumptech.glide.Glide

class ChatAdapter(var context: Context, val list: ArrayList<UserModel>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view:View):ViewHolder(view){
        var binding: ChatUserItemLayoutBinding = ChatUserItemLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
       return ChatViewHolder(LayoutInflater.from(parent.context)
           .inflate(R.layout.chat_user_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {


        val user = list[position]
        Glide.with(context).load(user.imageUrl).into(holder.binding.userImage)
        holder.binding.userName.text = user.name

        holder.itemView.setOnClickListener {
            val intent =Intent(context,ChatActivity::class.java)
            intent.putExtra("uid",user.uid)
            context.startActivity(intent)
        }
    }
}