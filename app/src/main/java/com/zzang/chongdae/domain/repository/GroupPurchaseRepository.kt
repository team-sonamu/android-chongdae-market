package com.zzang.chongdae.domain.repository

import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.domain.model.ArticleDetail
import com.zzang.chongdae.domain.model.CurrentCount

interface GroupPurchaseRepository {
    suspend fun getGroupPurchases()

    suspend fun getGroupPurchaseDetail(id: Long): Result<ArticleDetail>

    suspend fun participateGroupPurchase(groupPurchaseId: Long): Result<CurrentCount>
}
