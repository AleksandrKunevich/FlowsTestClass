package com.example.flowstestclass.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowstestclass.domain.AddNewsUseCase
import com.example.flowstestclass.domain.GetNewsUseCase
import com.example.flowstestclass.domain.getNewsUseCase
import com.example.flowstestclass.domain.model.DomainNews
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val addNewsUseCase: AddNewsUseCase
) : ViewModel() {

    private val _news = MutableLiveData<List<DomainNews>>()
    val news: LiveData<List<DomainNews>> get() = _news

    init {
        initNewsFlow()
    }

    private fun initNewsFlow() {
        viewModelScope.launch {
            getNewsUseCase.news.collect { news ->
                _news.value = news
            }
        }
    }

    fun addNews(title: String) {
        addNewsUseCase.addNews(
            DomainNews(title = title)
        )
    }
}