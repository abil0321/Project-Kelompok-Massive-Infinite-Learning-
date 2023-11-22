package com.example.massive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.massive.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
        binding.back3.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }
        binding.btnEditProfile.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))
        }
        binding.tentangKami.setOnClickListener {
            startActivity(Intent(this, TentangKami::class.java))
        }
        binding.layananKonsumen.setOnClickListener {
            startActivity(Intent(this, LayananKonsumen::class.java))
        }
    }
}