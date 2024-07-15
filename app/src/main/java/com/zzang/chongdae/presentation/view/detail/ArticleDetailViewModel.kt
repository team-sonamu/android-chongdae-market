package com.zzang.chongdae.presentation.view.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzang.chongdae.domain.model.ArticleDetail
import com.zzang.chongdae.domain.model.ArticleStatus
import com.zzang.chongdae.domain.model.ArticleStatus.Companion.isAvailable
import com.zzang.chongdae.domain.repository.GroupPurchaseRepository
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val articleId: Long,
    private val groupPurchaseRepository: GroupPurchaseRepository
) : ViewModel(), ParticipantClickListener {

    private val _articleDetail: MutableLiveData<ArticleDetail> = MutableLiveData()
    val articleDetail: LiveData<ArticleDetail> = _articleDetail

    private val _currentCount: MutableLiveData<Int> = MutableLiveData()
    val currentCount: LiveData<Int> = _currentCount

    private val _articleStatus: MutableLiveData<ArticleStatus> = MutableLiveData()
    val articleStatus: LiveData<ArticleStatus> = _articleStatus

    private val _isAvailable: MutableLiveData<Boolean> = MutableLiveData(true)
    val isAvailable: LiveData<Boolean> = _isAvailable

    init {
        loadArticle()
    }

    private fun loadArticle() {
        viewModelScope.launch {
            groupPurchaseRepository.getGroupPurchaseDetail(articleId).onSuccess {
                _articleDetail.value = it
                _currentCount.value = it.currentCount.currentCount
                _articleStatus.value = it.status
                _isAvailable.value = it.status.isAvailable()
            }.onFailure {
                Log.e("Error", it.message.toString())
            }
        }
    }

    override fun onClickParticipantButton() {
        viewModelScope.launch {
            groupPurchaseRepository.participateGroupPurchase(articleId).onSuccess {
                _currentCount.value = it.currentCount
/*                 API 변경 시 추가할 예정
                _articleStatus.value = it.status
                _isAvailable.value = it.status.isAvailable()*/
            }.onFailure {
                Log.e("Error", it.message.toString())
            }
        }
    }
}
