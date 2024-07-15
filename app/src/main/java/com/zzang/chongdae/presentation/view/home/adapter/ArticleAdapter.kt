package com.zzang.chongdae.presentation.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.zzang.chongdae.databinding.ItemArticleBinding
import com.zzang.chongdae.domain.model.Article
import com.zzang.chongdae.presentation.view.home.ArticleViewModel

class ArticleAdapter(
    private val articleViewModel: ArticleViewModel,
) : ListAdapter<Article, ArticleViewHolder>(productComparator) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ArticleViewHolder {
        val binding =
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ArticleViewHolder,
        position: Int,
    ) {
        holder.bind(currentList[position], articleViewModel)
    }

    companion object {
        private val productComparator =
            object : DiffUtil.ItemCallback<Article>() {
                override fun areItemsTheSame(
                    oldItem: Article,
                    newItem: Article,
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Article,
                    newItem: Article,
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}
