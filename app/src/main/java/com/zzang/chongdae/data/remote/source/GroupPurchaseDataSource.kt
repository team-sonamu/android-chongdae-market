package com.zzang.chongdae.data.remote.source

import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.data.remote.dto.GroupPurchasesResponse
import com.zzang.chongdae.data.remote.dto.ParticipateGroupRequest

interface GroupPurchaseDataSource {
    suspend fun getGroupPurchases(): Result<GroupPurchasesResponse>

    suspend fun getGroupPurchaseDetail(id: Long): Result<GroupPurchaseDetailResponse>

    suspend fun participateGroupPurchase(participateGroupRequest: ParticipateGroupRequest): Result<Unit>
}
