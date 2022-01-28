package com.example.flowstestclass.domain

import com.example.flowstestclass.data.NewsRepository
import com.example.flowstestclass.data.getNewsRepository
import com.example.flowstestclass.data.model.News
import com.example.flowstestclass.domain.model.DomainNews

fun getAddNewsUseCase(): AddNewsUseCase = AddNewsUseCaseImpl(
    newsRepository = getNewsRepository()
)

interface AddNewsUseCase {
    fun addNews(news: DomainNews)
}

class AddNewsUseCaseImpl(private val newsRepository: NewsRepository) : AddNewsUseCase {
    override fun addNews(news: DomainNews) {
        newsRepository.addNews(News(title = news.title))
    }

}