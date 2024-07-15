package com.zzang.chongdae.presentation.view.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.zzang.chongdae.databinding.ItemArticleBinding
import com.zzang.chongdae.domain.model.Article
import com.zzang.chongdae.presentation.view.home.ArticleViewModel

class ArticleViewHolder(
    private val binding: ItemArticleBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        article: Article,
        viewModel: ArticleViewModel,
    ) {
        binding.article = article
        binding.vm = viewModel
    }
}
