package com.zzang.chongdae.presentation.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zzang.chongdae.domain.repository.GroupPurchaseRepository

class ArticleDetailViewModelFactory(
    private val articleId: Long,
    private val groupPurchaseRepository: GroupPurchaseRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleDetailViewModel(
            articleId,
            groupPurchaseRepository,
        ) as T
    }
}
