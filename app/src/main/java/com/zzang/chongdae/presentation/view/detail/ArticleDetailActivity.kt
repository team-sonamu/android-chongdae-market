package com.zzang.chongdae.presentation.view.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zzang.chongdae.R
import com.zzang.chongdae.data.remote.api.NetworkManager
import com.zzang.chongdae.data.remote.source.impl.GroupPurchaseDataSourceImpl
import com.zzang.chongdae.data.repository.remote.GroupPurchaseRepositoryImpl
import com.zzang.chongdae.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailBinding
    private val articleId by lazy {
        obtainArticleId()
    }
    private val viewModel: ArticleDetailViewModel by viewModels {
        ArticleDetailViewModelFactory(
            articleId,
            GroupPurchaseRepositoryImpl(
                GroupPurchaseDataSourceImpl(NetworkManager.service()),
            ),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_detail)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun obtainArticleId() =
        intent.getLongExtra(
            EXTRA_ARTICLE_ID_KEY,
            EXTRA_DEFAULT_VALUE,
        )

    companion object {
        private const val EXTRA_DEFAULT_VALUE = -1L
        private const val EXTRA_ARTICLE_ID_KEY = "article_id_key"

        fun makeIntentInstance(
            context: Context,
            articleId: Long,
        ): Intent {
            val intent =
                Intent(context, ArticleDetailActivity::class.java).apply {
                    putExtra(EXTRA_ARTICLE_ID_KEY, articleId)
                }
            return intent
        }
    }
}
