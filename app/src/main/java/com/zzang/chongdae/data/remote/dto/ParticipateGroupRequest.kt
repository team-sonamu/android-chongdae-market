package com.zzang.chongdae.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ParticipateGroupRequest(
    @SerialName("groupPurchaseId") val groupPurchaseId: Long,
)
