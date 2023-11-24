package com.example.massive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityAturPengingatBinding

class AturPengingat : AppCompatActivity() {
    private lateinit var binding: ActivityAturPengingatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAturPengingatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}