package com.example.newsapptest.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapptest.models.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    suspend fun getAllArticle(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)
}