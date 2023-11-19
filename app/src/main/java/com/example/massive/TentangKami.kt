package com.example.massive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.databinding.ActivityTentangKamiBinding

class TentangKami : AppCompatActivity() {
    private lateinit var binding: ActivityTentangKamiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTentangKamiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}