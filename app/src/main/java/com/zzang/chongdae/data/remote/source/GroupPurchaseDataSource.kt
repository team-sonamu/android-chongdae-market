package com.zzang.chongdae.data.remote.source

import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.data.remote.dto.GroupPurchasesResponse
import com.zzang.chongdae.data.remote.dto.ParticipationsRequest
import com.zzang.chongdae.data.remote.dto.ParticipationsResponse

interface GroupPurchaseDataSource {
    suspend fun getGroupPurchases(): Result<GroupPurchasesResponse>

    suspend fun getGroupPurchaseDetail(id: Long): Result<GroupPurchaseDetailResponse>

    suspend fun participateGroupPurchase(participationsRequest: ParticipationsRequest): Result<ParticipationsResponse>
}
