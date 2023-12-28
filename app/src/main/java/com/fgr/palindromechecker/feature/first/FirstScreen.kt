package com.fgr.palindromechecker.feature.first

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.fgr.palindromechecker.databinding.ActivityFirstScreenBinding
import com.fgr.palindromechecker.feature.second.SecondScreen

class FirstScreen : AppCompatActivity() {
    private lateinit var binding: ActivityFirstScreenBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent = Intent()
        binding.firstScreenBtnCheck.setOnClickListener {
            hideKeyboard()
        }
        binding.firstScreenBtnNext.setOnClickListener {
            val username = binding.firstScreenEdName.text.toString()
            if (username.isNotEmpty()) {
                intent = Intent(this, SecondScreen::class.java)
                intent.putExtra(SecondScreen.EXTRAS.USERNAME, username)
                startActivity(intent)
            } else {
                binding.firstScreenEdName.error = "Username tidak boleh kosong"
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}