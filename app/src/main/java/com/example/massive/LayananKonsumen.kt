package com.example.massive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.databinding.ActivityLayananKonsumenBinding

class LayananKonsumen : AppCompatActivity() {
    private lateinit var binding: ActivityLayananKonsumenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayananKonsumenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}