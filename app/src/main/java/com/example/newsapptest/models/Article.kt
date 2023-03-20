package com.example.newsapptest.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String?,
    val content: String?,
    val publishedAt: String?,
    val description: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : java.io.Serializable