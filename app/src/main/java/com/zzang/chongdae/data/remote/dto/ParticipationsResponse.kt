package com.zzang.chongdae.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParticipationsResponse(
    val status: PurchaseStatus,
    val currentCount: Int,
)
