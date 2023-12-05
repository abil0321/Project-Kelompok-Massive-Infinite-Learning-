package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityInfo3Binding

class Info3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityInfo3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfo3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back23.setOnClickListener {
            startActivity(Intent(this, InfoAnemia::class.java))
        }
    }
}