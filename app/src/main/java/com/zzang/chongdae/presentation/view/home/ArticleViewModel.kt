package com.zzang.chongdae.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zzang.chongdae.data.local.source.articlesDummyData
import com.zzang.chongdae.domain.model.Article

class ArticleViewModel : ViewModel() {
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articles: LiveData<List<Article>> get() = _articles

    fun updateArticles() {
        _articles.value = articlesDummyData
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return ArticleViewModelFactory()
        }
    }
}
