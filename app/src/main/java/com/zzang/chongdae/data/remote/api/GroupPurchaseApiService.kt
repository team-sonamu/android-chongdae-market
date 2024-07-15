package com.zzang.chongdae.data.remote.api

import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.data.remote.dto.GroupPurchasesResponse
import com.zzang.chongdae.data.remote.dto.ParticipateGroupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GroupPurchaseApiService {
    @GET("/group-purchases")
    suspend fun getGroupPurchases(): Response<GroupPurchasesResponse>

    @GET("/group-purchases/{id}")
    suspend fun getGroupPurchaseDetail(
        @Path("id") id: Long,
    ): Response<GroupPurchaseDetailResponse>

    @POST("/group-purchases/{id}/participate")
    suspend fun participateGroupPurchase(
        @Body participateGroupRequest: ParticipateGroupRequest,
    ): Response<Unit>
}
