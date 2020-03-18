package com.example.retrofitid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitid.R
import com.example.retrofitid.model.Article
import com.example.retrofitid.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter (var articlesList: List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    inner class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(articles : Article){
            itemView.txtTitle.text = articles.title
            itemView.txtcontent.text = articles.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articlesList[position])
    }

}