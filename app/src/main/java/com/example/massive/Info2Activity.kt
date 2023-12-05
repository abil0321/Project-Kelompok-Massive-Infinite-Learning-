package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityInfo2Binding

class Info2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityInfo2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfo2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back22.setOnClickListener {
            startActivity(Intent(this, InfoAnemia::class.java))
        }
    }
}