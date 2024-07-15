package com.zzang.chongdae.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupPurchasesResponse(
    @SerialName("groupPurchases") val groupPurchases: List<GroupPurchase>,
)
