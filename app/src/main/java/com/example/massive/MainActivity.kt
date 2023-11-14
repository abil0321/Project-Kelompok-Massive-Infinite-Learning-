package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import com.example.massive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressBar = findViewById<ProgressBar>(R.id.loading)
        val textView = findViewById<TextView>(R.id.persen)

        progressBar.max = 100
        progressBar.scaleY = 3F
        val anim = Loadingscreen(
            this,progressBar,textView,0F,100F
        )
        anim.duration = 8000
        progressBar.animation = anim

    }
}