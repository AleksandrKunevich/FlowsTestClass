package com.example.flowstestclass.data

import com.example.flowstestclass.data.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepositoryImpl : NewsRepository {

    override val news: Flow<List<News>> = flow {
        while (true) {
            val news = NewsApi.getNews()
            emit(news)
            delay(5000)
        }
    }


    override fun addNews(news: News) {
        NewsApi.addNews(news)
    }
}