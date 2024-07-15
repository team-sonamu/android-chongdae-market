package com.zzang.chongdae.presentation.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zzang.chongdae.R
import com.zzang.chongdae.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bottomNav.selectedItemId = R.id.home_fragment_item
        showFragment(HomeFragment())
        binding.bottomNav.setOnItemSelectedListener { item ->
            convertFragment(item.itemId)
            true
        }
    }

    private fun convertFragment(itemId: Int) {
        when (itemId) {
            R.id.home_fragment_item -> showFragment(HomeFragment())
            R.id.my_page_fragment_item -> showFragment(MyPageFragment())
            R.id.chatting_fragment_item -> showFragment(ChattingFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment)
            .commitAllowingStateLoss()
    }
}
