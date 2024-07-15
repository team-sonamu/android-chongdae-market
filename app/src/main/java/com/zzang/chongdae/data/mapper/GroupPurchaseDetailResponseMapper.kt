package com.zzang.chongdae.data.mapper

import com.zzang.chongdae.data.remote.dto.GroupPurchaseDetailResponse
import com.zzang.chongdae.domain.model.ArticleDetail
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun GroupPurchaseDetailResponse.toDomain() =
    ArticleDetail(
        id = this.id,
        nickname = this.nickname,
        productUrl = this.productUrl,
        splitPrice = this.splitPrice,
        totalPrice = this.totalPrice,
        dueDateTime = this.deadline.toLocalDateTime(),
        meetingAddress = this.meetingAddress,
        meetingAddressDetail = this.meetingAddressDetail,
        description = this.description,
        status = this.status,
    )

fun String.toLocalDateTime(): LocalDateTime =
    LocalDateTime.parse(this, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

