package com.fgr.palindromechecker.feature.third

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fgr.palindromechecker.common.vm_factory.ViewModelFactory
import com.fgr.palindromechecker.data.response.UserResponse
import com.fgr.palindromechecker.databinding.ActivityThirdScreenBinding
import com.fgr.palindromechecker.feature.second.SecondScreen
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ThirdScreen : AppCompatActivity() {
    private lateinit var binding: ActivityThirdScreenBinding
    private lateinit var adapter: UserRvAdapter
    private val viewModel: ThirdViewModel by viewModels {
        ViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycleView()
        binding.thirdScreenSwipeRefreshLayout.setOnRefreshListener {
            binding.thirdScreenSwipeRefreshLayout.isRefreshing = false
            adapter.refresh()
            scrollToTop()
        }
        binding.thirdScreenBtnBack.setOnClickListener {
            finish()
        }
    }

    private fun scrollToTop() {
        binding.thirdScreenRv.post {
            binding.thirdScreenRv.smoothScrollToPosition(0)
        }
    }

    private fun onSelected(user: UserResponse) {
        val resultIntent = Intent()
        resultIntent.putExtra(
            SecondScreen.CONSTANT.NEW_USERNAME,
            "${user.firstName} ${user.lastName}"
        )
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    private fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        binding.thirdScreenRv.layoutManager = layoutManager
        adapter = UserRvAdapter(
            onItemClicked = ::onSelected,
        )
        binding.thirdScreenRv.adapter = adapter
        lifecycleScope.launch {
            viewModel.users.collect { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}