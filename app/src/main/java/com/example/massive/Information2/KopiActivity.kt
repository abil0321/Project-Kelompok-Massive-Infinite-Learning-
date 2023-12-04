package com.example.massive.Information2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.Nutrisi
import com.example.massive.R
import com.example.massive.Profile
import com.example.massive.databinding.ActivityKopiBinding

class KopiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKopiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKopiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back12.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToNutrisiFragment() {
        startActivity(Intent(this, Nutrisi::class.java))
    }
}