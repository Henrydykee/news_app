package com.example.news_app.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.Adapter.ViewHolder.ListSourceViewHolder
import com.example.news_app.Interface.ItemClickListener
import com.example.news_app.ListNews
import com.example.news_app.Model.WebSite
import com.example.news_app.R
import kotlinx.android.synthetic.main.source_news.view.*

class ListSourceAdapter(private val context : Context,private val webSite: WebSite):
    RecyclerView.Adapter<ListSourceViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.source_news,parent,false)
        return ListSourceViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return webSite.sources!!.size
    }

    override fun onBindViewHolder(holder: ListSourceViewHolder, position: Int) {
        holder.source_title.text = webSite.sources!![position].name
        holder.setItemClickListener(object : ItemClickListener
        {
            override fun onClick(view: View, position: Int) {
                //Toast.makeText(context,"workiNews 24/7",Toast.LENGTH_SHORT).show()
                val intent =  Intent(context,ListNews::class.java)
                intent.putExtra("source",webSite.sources!![position].id)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }

        })
    }
}