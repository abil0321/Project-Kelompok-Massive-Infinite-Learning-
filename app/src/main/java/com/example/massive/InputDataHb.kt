package com.example.massive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.databinding.ActivityInputDataHbBinding

class InputDataHb : AppCompatActivity() {
    private lateinit var binding: ActivityInputDataHbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataHbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener {
            startActivity(Intent(this, AnemiaStatus::class.java))
        }
    }
}