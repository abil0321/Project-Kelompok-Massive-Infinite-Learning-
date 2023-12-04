package com.example.massive.Information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.Nutrisi
import com.example.massive.R
import com.example.massive.databinding.ActivityKacangMerahBinding

class KacangMerahActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKacangMerahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKacangMerahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back16.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToNutrisiFragment() {
        startActivity(Intent(this, Nutrisi::class.java))
    }
}