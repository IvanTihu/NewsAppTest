package com.example.newsapptest.data.api

import javax.inject.Inject

class TestRepo @Inject constructor(private val newsService: NewsService) {

    suspend fun getAll() = newsService.getHeadLines()
}