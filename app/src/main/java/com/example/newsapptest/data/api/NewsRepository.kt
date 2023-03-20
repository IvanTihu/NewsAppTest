package com.example.newsapptest.data.api

import com.example.newsapptest.data.db.ArticleDao
import com.example.newsapptest.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService,
    private val articleDao: ArticleDao
) {

    suspend fun getNews(countryCode: String, page: Int) =
        newsService.getHeadLines(countryCode, page)

    suspend fun getSearchNews(query: String, pageNumber: Int) =
        newsService.getEverything(query = query, page = pageNumber)

    fun getFavoriteArticles() = articleDao.getAllArticle()

    suspend fun addToFavorite(article: Article) = articleDao.insert(article)
    suspend fun deleteFromFavorite(article: Article) = articleDao.delete(article)
}