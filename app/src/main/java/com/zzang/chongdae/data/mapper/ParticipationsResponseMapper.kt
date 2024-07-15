package com.zzang.chongdae.data.mapper

import com.zzang.chongdae.data.remote.dto.ParticipationsResponse
import com.zzang.chongdae.domain.model.CurrentCount

fun ParticipationsResponse.toDomain() = CurrentCount(this.currentCount)
