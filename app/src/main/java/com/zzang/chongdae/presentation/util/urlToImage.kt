package com.zzang.chongdae.presentation.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.urlToImage(
    context: Context,
    imageUrl: String,
) {
    imageUrl?.let { url ->
        Glide.with(context)
            .load(url)
            .into(this)
    }
}
