package com.fgr.palindromechecker.feature.second

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.fgr.palindromechecker.R
import com.fgr.palindromechecker.databinding.ActivitySecondScreenBinding
import com.fgr.palindromechecker.feature.third.ThirdScreen

class SecondScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    private lateinit var startForResultLauncher: ActivityResultLauncher<Intent>

    object CONSTANT {
        const val USERNAME = "SECOND_SCREEN_USERNAME"
        const val NEW_USERNAME = "SECOND_SCREEN_NEW_USERNAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUsername()
        setNewUsername()
        binding.secondScreenBtnBack.setOnClickListener {
            finish()
        }
        binding.secondScreenBtnChooseAUser.setOnClickListener {
            startForResultLauncher.launch(Intent(this, ThirdScreen::class.java))
        }
    }

    private fun setNewUsername() {
        startForResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val newUsername = data?.getStringExtra(CONSTANT.NEW_USERNAME)
                binding.secondScreenSelectedUsername.text = newUsername
            }
        }
    }
    private fun setUsername() {
        val username = intent.getStringExtra(CONSTANT.USERNAME) ?: getString(R.string.empty)
        binding.secondScreenUsername.text = username
    }
}