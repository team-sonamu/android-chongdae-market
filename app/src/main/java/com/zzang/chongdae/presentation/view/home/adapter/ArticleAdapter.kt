package com.zzang.chongdae.presentation.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.zzang.chongdae.databinding.ItemArticleBinding
import com.zzang.chongdae.databinding.ItemArticleClosedBinding
import com.zzang.chongdae.domain.model.Article
import com.zzang.chongdae.domain.model.ArticleType
import com.zzang.chongdae.presentation.view.home.ArticleViewModel

class ArticleAdapter(
    private val articleViewModel: ArticleViewModel,
    private val onArticleClickListener: OnArticleClickListener,
) : ListAdapter<Article, ArticleViewHolder>(productComparator) {
    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].isOpened == true) {
            ArticleType.OPEN.separator
        } else {
            ArticleType.CLOSE.separator
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ArticleViewHolder {
        when (viewType) {
            ArticleType.OPEN.separator -> {
                val binding =
                    ItemArticleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    )
                return ArticleViewHolder.Open(binding)
            }

            ArticleType.CLOSE.separator -> {
                val binding =
                    ItemArticleClosedBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    )
                return ArticleViewHolder.Close(binding)
            }

            else -> error("Invalid view type")
        }
    }

    override fun onBindViewHolder(
        holder: ArticleViewHolder,
        position: Int,
    ) {
        when (holder) {
            is ArticleViewHolder.Open -> holder.bind(currentList[position], onArticleClickListener)
            is ArticleViewHolder.Close -> holder.bind(currentList[position], onArticleClickListener)
        }
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
