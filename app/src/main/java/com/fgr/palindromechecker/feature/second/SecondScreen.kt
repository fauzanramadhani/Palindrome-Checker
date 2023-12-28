package com.fgr.palindromechecker.feature.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fgr.palindromechecker.databinding.ActivitySecondScreenBinding

class SecondScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding

    object EXTRAS {
        const val USERNAME = "SECOND_SCREEN_USERNAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.secondScreenBtnBack.setOnClickListener {
            finish()
        }
        setUsername()
    }

    private fun setUsername() {
        val username = intent.getStringExtra(EXTRAS.USERNAME) ?: "Empty"
        binding.secondScreenUsername.text = username
    }
}