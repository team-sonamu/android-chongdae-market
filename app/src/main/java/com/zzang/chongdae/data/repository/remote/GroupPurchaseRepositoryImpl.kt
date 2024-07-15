package com.zzang.chongdae.data.repository.remote

import com.zzang.chongdae.data.mapper.toDomain
import com.zzang.chongdae.data.remote.dto.ParticipateGroupRequest
import com.zzang.chongdae.data.remote.source.GroupPurchaseDataSource
import com.zzang.chongdae.domain.model.ArticleDetail
import com.zzang.chongdae.domain.repository.GroupPurchaseRepository

class GroupPurchaseRepositoryImpl(
    private val groupPurchaseDataSource: GroupPurchaseDataSource,
) : GroupPurchaseRepository {
    override suspend fun getGroupPurchases() {
        TODO("Not yet implemented")
    }

    override suspend fun getGroupPurchaseDetail(id: Long): Result<ArticleDetail> {
        return groupPurchaseDataSource.getGroupPurchaseDetail(id = id).mapCatching {
            it.toDomain()
        }
    }

    override suspend fun participateGroupPurchase(groupPurchaseId: Long): Result<Unit> {
        return groupPurchaseDataSource.participateGroupPurchase(
            participateGroupRequest = ParticipateGroupRequest(groupPurchaseId)
        )
    }
}
