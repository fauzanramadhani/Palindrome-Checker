package com.fgr.palindromechecker.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fgr.palindromechecker.databinding.ActivityMainBinding
import com.fgr.palindromechecker.feature.first.FirstScreen

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivity(Intent(this, FirstScreen::class.java))
        finish()
    }
}