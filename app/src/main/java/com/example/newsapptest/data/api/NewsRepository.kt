package com.example.newsapptest.data.api

import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsService) {

    suspend fun getNews(countryCode: String, page: Int) =
        newsService.getHeadLines(countryCode, page)
}