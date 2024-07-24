package com.zzang.chongdae.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzang.chongdae.domain.model.Article
import com.zzang.chongdae.domain.repository.GroupPurchaseRepository
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val groupPurchaseRepository: GroupPurchaseRepository,
) : ViewModel() {
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articles: LiveData<List<Article>> get() = _articles

    fun updateArticles() {
        viewModelScope.launch {
            groupPurchaseRepository.getGroupPurchases().onSuccess {
                _articles.value = it
            }.onFailure {
            }
        }
    }
}
