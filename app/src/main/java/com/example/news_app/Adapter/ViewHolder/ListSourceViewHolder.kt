package com.example.news_app.Adapter.ViewHolder

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.Interface.ItemClickListener
import kotlinx.android.synthetic.main.source_news.view.*

class ListSourceViewHolder (itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
    private lateinit var itemClickListener: ItemClickListener
    var source_title = itemView.source_news_name

    init {
        itemView.setOnClickListener(this)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener)
    {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(p0: View?) {
        itemClickListener.onClick(p0!!,adapterPosition)

    }



}