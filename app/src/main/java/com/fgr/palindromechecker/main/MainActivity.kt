package com.fgr.palindromechecker.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fgr.palindromechecker.R
import com.fgr.palindromechecker.feature.first.FirstScreen
import com.fgr.palindromechecker.feature.second.SecondScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, SecondScreen::class.java))
        finish()
    }
}