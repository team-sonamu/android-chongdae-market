package com.zzang.chongdae.data.remote.source.impl

import com.zzang.chongdae.data.remote.api.GroupPurchaseApiService
import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.data.remote.dto.GroupPurchasesResponse
import com.zzang.chongdae.data.remote.dto.ParticipationRequest
import com.zzang.chongdae.data.remote.dto.ParticipationResponse
import com.zzang.chongdae.data.remote.source.GroupPurchaseDataSource

class GroupPurchaseDataSourceImpl(
    private val service: GroupPurchaseApiService,
) : GroupPurchaseDataSource {
    override suspend fun getGroupPurchases(): Result<GroupPurchasesResponse> =
        runCatching {
            service.getArticles().body() ?: throw IllegalStateException()
        }

    override suspend fun getGroupPurchaseDetail(id: Long): Result<GroupPurchaseDetailResponse> =
        runCatching {
            service.getArticleDetail(id = id).body() ?: throw IllegalStateException()
        }

    override suspend fun participateGroupPurchase(participationRequest: ParticipationRequest): Result<ParticipationResponse> =
        runCatching {
            service.postParticipation(participationRequest = participationRequest)
                .body() ?: throw IllegalStateException()
        }
}
