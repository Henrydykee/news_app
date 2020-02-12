package com.example.news_app.Common

import com.example.news_app.Interface.NewsService
import com.example.news_app.Model.Source
import com.example.news_app.Remote.RetrofitClient
import retrofit2.Retrofit
import java.lang.StringBuilder

object Common {
    val BASE_URL ="https://newsapi.org"
    val API_KEY ="899676a9899546639657d056beca2548"

    val newsService: NewsService
    get() = RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

    fun getNewsApi(source: String): String{
        val apiUrl = StringBuilder("https://newsapi.org/v2/top-headlines?sources=")
            .append(source)
            .append("&apiKey=")
            .append(API_KEY)
            .toString()
        return  apiUrl
    }
}