package com.example.massive.Information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.Nutrisi
import com.example.massive.R
import com.example.massive.databinding.ActivityTahuctivityBinding

class Tahuctivity : AppCompatActivity() {
    private lateinit var binding: ActivityTahuctivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahuctivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back14.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToNutrisiFragment() {
        startActivity(Intent(this, Nutrisi::class.java))
    }
}