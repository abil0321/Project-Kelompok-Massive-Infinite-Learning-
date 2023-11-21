package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityTentangKamiBinding

class TentangKamiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTentangKamiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTentangKamiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back3.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }
    }
}