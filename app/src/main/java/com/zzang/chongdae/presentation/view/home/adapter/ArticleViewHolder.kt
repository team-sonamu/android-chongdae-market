package com.zzang.chongdae.presentation.view.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zzang.chongdae.databinding.ItemArticleBinding
import com.zzang.chongdae.databinding.ItemArticleClosedBinding
import com.zzang.chongdae.domain.model.Article

sealed class ArticleViewHolder(
    view: View,
) : RecyclerView.ViewHolder(view) {
    class Open(
        private val binding: ItemArticleBinding,
    ) : ArticleViewHolder(binding.root) {
        fun bind(
            article: Article,
            onArticleClickListener: OnArticleClickListener,
        ) {
            binding.article = article
            binding.onArticleClickListener = onArticleClickListener
        }
    }

    class Close(
        private val binding: ItemArticleClosedBinding,
    ) : ArticleViewHolder(binding.root) {
        fun bind(
            article: Article,
            onArticleClickListener: OnArticleClickListener,
        ) {
            binding.article = article
            binding.onArticleClickListener = onArticleClickListener
        }
    }
//    fun bind(
//        article: Article,
//        onArticleClickListener: OnArticleClickListener,
//    ) {
//        binding.article = article
//        binding.onArticleClickListener = onArticleClickListener
//    }
}
