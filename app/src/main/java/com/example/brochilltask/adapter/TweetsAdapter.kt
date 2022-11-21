package com.example.brochilltask.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brochilltask.R
import com.example.example.TweetsResponse

class TweetsAdapter(val context: Context, val list: ArrayList<TweetsResponse>) :
    RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = list[position]
        holder.text.text = list.tweet
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.tweets)
    }

}