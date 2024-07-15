package com.zzang.chongdae.data.remote.source.impl

import com.zzang.chongdae.data.remote.api.GroupPurchaseApiService
import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.data.remote.dto.GroupPurchasesResponse
import com.zzang.chongdae.data.remote.dto.ParticipateGroupRequest
import com.zzang.chongdae.data.remote.source.GroupPurchaseDataSource

class GroupPurchaseDataSourceImpl
    (
    private val service: GroupPurchaseApiService,
) : GroupPurchaseDataSource {
    override suspend fun getGroupPurchases(): Result<GroupPurchasesResponse> = runCatching {
        service.getGroupPurchases().body() ?: throw IllegalStateException()
    }

    override suspend fun getGroupPurchaseDetail(id: Long): Result<GroupPurchaseDetailResponse> =
        runCatching {
            service.getGroupPurchaseDetail(id = id).body() ?: throw IllegalStateException()
        }

    override suspend fun participateGroupPurchase(participateGroupRequest: ParticipateGroupRequest): Result<Unit> =
        runCatching {
            service.participateGroupPurchase(participateGroupRequest = participateGroupRequest)
                .body()
        }
}
