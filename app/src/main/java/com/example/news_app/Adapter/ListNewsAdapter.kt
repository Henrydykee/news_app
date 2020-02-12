package com.example.news_app.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.Adapter.ViewHolder.ListNewsViewHolder
import com.example.news_app.Common.ISO8601Praser
import com.example.news_app.DetailNews
import com.example.news_app.Interface.ItemClickListener
import com.example.news_app.Model.Article
import com.example.news_app.R
import com.google.gson.internal.bind.util.ISO8601Utils
import com.squareup.picasso.Picasso
import java.text.ParseException
import java.util.*

class ListNewsAdapter (private val articleList: MutableList<Article>,private val context: Context):RecyclerView.Adapter<ListNewsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val itemView=inflater.inflate(R.layout.news_layout,parent,false)
        return ListNewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return articleList.size
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
        Picasso.with(context)
            .load(articleList[position].urlToImage)
            .into( holder.ariticle_image)
        if (articleList[position].title!!.length > 65)
        {
            holder.article_title.text= articleList[position].title!!.substring(0,65)+"..."
        }else{
            holder.article_title.text= articleList[position].title
        }
        if (articleList[position].publishedAt !=null)
        {
            var date : Date?=null
            try {
                date = ISO8601Praser.prase(articleList[position].publishedAt!!)
            }catch (
                ex:ParseException
            ){
                ex.printStackTrace()
            }

            //holder.ariticle_time.setReferenceTime(date!!.time)
        }

        holder.setItemClickListener(object : ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val detail = Intent(context,DetailNews::class.java)
                detail.putExtra("webURL",articleList[position].url)
                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(detail)
            }

        })


    }

}