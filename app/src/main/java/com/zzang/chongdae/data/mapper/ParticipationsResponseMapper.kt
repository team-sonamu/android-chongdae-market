package com.zzang.chongdae.data.mapper

import com.zzang.chongdae.data.remote.dto.ParticipationsResponse
import com.zzang.chongdae.domain.model.Participation

fun ParticipationsResponse.toDomain() = Participation(
    status = this.status.toDomain(),
    this.currentCount.toCurrentCount()
)
