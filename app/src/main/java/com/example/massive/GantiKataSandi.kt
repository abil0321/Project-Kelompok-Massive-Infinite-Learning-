package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityGantiKataSandiBinding

class GantiKataSandi : AppCompatActivity() {
    private lateinit var binding: ActivityGantiKataSandiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGantiKataSandiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAturSandi.setOnClickListener {
            onBackPressed()
        }
        binding.textView2.setOnClickListener {
            onBackPressed()
        }
    }
    private fun navigateToProfileFragment() {
        startActivity(Intent(this, Profile::class.java))
    }
}