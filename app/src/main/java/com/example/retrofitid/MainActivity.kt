package com.example.retrofitid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitid.adapter.NewsAdapter
import com.example.retrofitid.api.NewApiInterface
import com.example.retrofitid.model.Article
import com.example.retrofitid.model.News
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAricles()
    }

    fun loadArticleList (articlesList: List<Article>){

        var newsAdapter = NewsAdapter(articlesList)
        recyclerviewNews.layoutManager = LinearLayoutManager(this)
        recyclerviewNews.adapter = newsAdapter
    }


    fun getAricles() {

        var BASE_URL = "http://newsapi.org/v2/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(NewApiInterface::class.java)

        var apiCall = retrofitService.getNews("us","business","3978438e66ba471b80ec4004ca6e36d2")

        apiCall.enqueue(object : Callback<News>
        {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("faiure >>>>>> ",toString())
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {

                var articleList = response.body()?.articles
                Log.d("response >>>>>",articleList.toString())
                if (articleList != null) {
                    loadArticleList(articleList)
                }


            }
        })



    }

}

