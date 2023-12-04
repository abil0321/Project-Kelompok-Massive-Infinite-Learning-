package com.example.massive.Information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.Nutrisi
import com.example.massive.Profile
import com.example.massive.R
import com.example.massive.databinding.ActivityBayamBinding

class BayamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBayamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBayamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back10.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToNutrisiFragment() {
        startActivity(Intent(this, Nutrisi::class.java))
    }
}