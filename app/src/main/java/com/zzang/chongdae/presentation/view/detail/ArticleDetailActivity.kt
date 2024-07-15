package com.zzang.chongdae.presentation.view.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zzang.chongdae.R
import com.zzang.chongdae.data.remote.api.GroupPurchaseApiService
import com.zzang.chongdae.data.remote.api.NetworkManager
import com.zzang.chongdae.data.remote.source.impl.GroupPurchaseDataSourceImpl
import com.zzang.chongdae.data.repository.remote.GroupPurchaseRepositoryImpl
import com.zzang.chongdae.databinding.ActivityArticleDetailBinding
import com.zzang.chongdae.domain.repository.GroupPurchaseRepository

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailBinding
    private val articleId by lazy { getArticleId() }
    private val viewModel: ArticleDetailViewModel by viewModels {
        ArticleDetailViewModelFactory(
            articleId,
            GroupPurchaseRepositoryImpl(
                GroupPurchaseDataSourceImpl(NetworkManager.groupPurchaseService()),
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

    private fun getArticleId() = intent.getLongExtra(
        "ARTICLE_ID",
        EXTRA_DEFAULT_VALUE,
    )

    companion object {
        private const val EXTRA_DEFAULT_VALUE = -1L
    }
}
