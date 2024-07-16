package com.zzang.chongdae.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupPurchase(
    val id: Long,
    val title: String,
    val meetingAddress: String,
    val deadline: String,
    val currentCount: Int,
    val totalCount: Int,
    val thumbnailUrl: String,
    val splitPrice: Int,
    val isClosed: Boolean,
)
