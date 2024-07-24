package com.zzang.chongdae.presentation.util

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.zzang.chongdae.R
import com.zzang.chongdae.domain.model.ArticleStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@BindingAdapter("imageUrl")
fun ImageView.bindUrlToImage(imageUrl: String?) {
    urlToImage2(context, imageUrl)
}

@BindingAdapter("dueDateTime")
fun TextView.bindDueDateTime(datetime: LocalDateTime) {
    this.text =
        datetime.format(DateTimeFormatter.ofPattern(context.getString(R.string.due_datetime)))
}

@BindingAdapter("currentCount", "totalCount", "status")
fun TextView.bindStatusComment(
    currentCount: Int,
    totalCount: Int,
    status: ArticleStatus,
) {
    this.text = status.toComment(this.context, currentCount, totalCount)
}

private fun ArticleStatus.toComment(
    context: Context,
    currentCount: Int,
    totalCount: Int,
) = when (this) {
    ArticleStatus.FULL -> context.getString(R.string.participant_full)
    ArticleStatus.TIME_OUT -> context.getString(R.string.participant_end)
    ArticleStatus.CONFIRMED -> context.getString(R.string.participant_end)
    ArticleStatus.AVAILABLE ->
        context.getString(
            R.string.participant_count,
            currentCount,
            totalCount,
        )
}
