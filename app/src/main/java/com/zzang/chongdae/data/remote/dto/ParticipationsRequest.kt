package com.zzang.chongdae.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ParticipationsRequest(
    @SerialName("articleId") val articleId: Long,
)
