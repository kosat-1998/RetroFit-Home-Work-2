package com.example.retrofitid.api

import com.example.retrofitid.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApiInterface {

@GET("top-headlines")
fun getNews(
    @Query("country")country : String,
    @Query("category")category: String,
    @Query ("apiKey")apiKey : String
    ):Call<News>

}