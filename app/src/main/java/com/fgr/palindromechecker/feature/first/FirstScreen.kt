package com.fgr.palindromechecker.feature.first

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.fgr.palindromechecker.R
import com.fgr.palindromechecker.databinding.ActivityFirstScreenBinding
import com.fgr.palindromechecker.feature.second.SecondScreen
import com.fgr.palindromechecker.utils.isPalindrome

class FirstScreen : AppCompatActivity() {
    private lateinit var binding: ActivityFirstScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstScreenBtnCheck.setOnClickListener {
            hideKeyboard()
            val text = binding.firstScreenEdPalindrome.text.toString()
            if (text.isNotEmpty()) {
                binding.firstScreenResultLayout.visibility = View.VISIBLE
                if (text.isPalindrome()) {
                    binding.firstScreenResultText.setText(R.string.true_palindrome)
                } else {
                    binding.firstScreenResultText.setText(R.string.false_palindrome)
                }
            } else {
                binding.firstScreenEdPalindrome.error = getString(R.string.empty_palindrome)
            }
        }
        binding.firstScreenResultCloseButton.setOnClickListener {
            binding.firstScreenResultLayout.visibility = View.GONE
        }
        binding.firstScreenBtnNext.setOnClickListener {
            val username = binding.firstScreenEdName.text.toString()
            if (username.isNotEmpty()) {
                val intent = Intent(this, SecondScreen::class.java)
                intent.putExtra(SecondScreen.EXTRAS.USERNAME, username)
                startActivity(intent)
            } else {
                binding.firstScreenEdName.error = getString(R.string.empty_username)
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}