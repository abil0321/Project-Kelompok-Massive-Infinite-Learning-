package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityInfoAnemiaBinding

class InfoAnemia : AppCompatActivity() {
    private lateinit var binding: ActivityInfoAnemiaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoAnemiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBaca1.setOnClickListener {
            startActivity(Intent(this, Info1::class.java))
        }

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToProfileFragment() {
        startActivity(Intent(this, Home::class.java))
    }
}