package com.zzang.chongdae.presentation.util

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageResource(
        view: ImageView,
        imageUrl: String?,
    ) {
        imageUrl.let {
            Glide.with(view.context)
                .load(it)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("app:formattedDate")
    fun setFormattedDate(
        view: TextView,
        dateTime: LocalDateTime?,
    ) {
        dateTime?.let {
            val formatter = DateTimeFormatter.ofPattern("MM'월' dd'일' HH'시'")
            view.text = it.format(formatter)
        }
    }
}
