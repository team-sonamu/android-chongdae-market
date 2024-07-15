package com.zzang.chongdae.presentation.view.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.zzang.chongdae.databinding.ItemArticleBinding
import com.zzang.chongdae.domain.model.Article

class ArticleViewHolder(
    private val binding: ItemArticleBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        article: Article,
        onArticleClickListener: OnArticleClickListener,
    ) {
        binding.article = article
        binding.onArticleClickListener = onArticleClickListener
    }
}
