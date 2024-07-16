package com.zzang.chongdae.presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zzang.chongdae.domain.repository.GroupPurchaseRepository

class ArticleViewModelFactory(
    private val groupPurchaseRepository: GroupPurchaseRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(groupPurchaseRepository) as T
    }
}
