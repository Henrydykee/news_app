package com.example.news_app.Adapter.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.Interface.ItemClickListener
import kotlinx.android.synthetic.main.news_layout.view.*

class ListNewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
    private lateinit var itemClickListener: ItemClickListener
    var article_title = itemView.ariticle_title
    var ariticle_time= itemView.ariticle_time!!
    var ariticle_image=itemView.ariticle_image
    init {
        itemView.setOnClickListener(this)
    }
    fun setItemClickListener(itemClickListener: ItemClickListener)
    {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(p0: View) {
        itemClickListener.onClick(p0,adapterPosition)
    }

}