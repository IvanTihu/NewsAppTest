package com.example.newsapptest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapptest.databinding.ItemArticleBinding
import com.example.newsapptest.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }



    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    class NewsViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(article: Article) {
                binding.apply {
                    Glide.with(binding.root).load(article.urlToImage).into(articleImage)
                    articleImage.clipToOutline = true
                    articleTitle.text = article.title
                    articleDate.text = article.publishedAt
                }
            }

    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}