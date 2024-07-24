package com.zzang.chongdae.presentation.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zzang.chongdae.databinding.FragmentHomeBinding
import com.zzang.chongdae.presentation.view.detail.ArticleDetailActivity.Companion.makeIntentInstance
import com.zzang.chongdae.presentation.view.home.adapter.ArticleAdapter
import com.zzang.chongdae.presentation.view.home.adapter.OnArticleClickListener

class HomeFragment : Fragment(), OnArticleClickListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var articleAdapter: ArticleAdapter
    private val viewModel by viewModels<ArticleViewModel> {
        ArticleViewModel.factory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        articleAdapter = ArticleAdapter(viewModel, this)
        binding.rvArticles.adapter = articleAdapter
        articleAdapter.submitList(viewModel.articles.value)
        viewModel.articles.observe(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
        viewModel.updateArticles()
        return binding.root
    }

    override fun onClick(articleId: Long) {
        val intent = makeIntentInstance(activity as Context, articleId)
        startActivity(intent)
    }

    // hihihihi~~~~~~~~!!!!!
}
