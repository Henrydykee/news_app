package com.example.news_app.Interface

import com.example.news_app.Model.News
import com.example.news_app.Model.WebSite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {
    @get : GET ("v2/sources?apiKey=5e8489b114f44c98ae2e7159bd59bdfe")
    val  sources: Call<WebSite>
    @GET
    fun getNewsFromSource(@Url url:String):Call<News>
}