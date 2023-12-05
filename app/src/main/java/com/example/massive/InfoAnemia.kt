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
        binding.btnBaca2.setOnClickListener {
            startActivity(Intent(this, Info2Activity::class.java))
        }
        binding.btnBaca3.setOnClickListener {
            startActivity(Intent(this, Info3Activity::class.java))
        }

        binding.backbutton.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
    private fun navigateToProfileFragment() {
        startActivity(Intent(this, Home::class.java))
    }
}