package com.zzang.chongdae.domain.model

import com.zzang.chongdae.data.remote.dto.PurchaseStatus
import java.time.LocalDateTime

data class ArticleDetail(
    val id: Long = 0,
    val nickname: String,
    val productUrl: String,
    val splitPrice: Int,
    val totalPrice: Int,
    val dueDateTime: LocalDateTime,
    val meetingAddress: String,
    val meetingAddressDetail: String,
    val description: String,
    val status: PurchaseStatus,
)