package com.example.massive.Information2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.Nutrisi
import com.example.massive.R
import com.example.massive.Profile
import com.example.massive.databinding.ActivityYogurtBinding

class YogurtActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYogurtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYogurtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back17.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToNutrisiFragment() {
        startActivity(Intent(this, Nutrisi::class.java))
    }
}