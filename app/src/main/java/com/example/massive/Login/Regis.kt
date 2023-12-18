package com.example.massive.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.massive.R
import com.example.massive.databinding.ActivityLoginBinding
import com.example.massive.databinding.ActivityRegisBinding

class Regis : AppCompatActivity() {
    private lateinit var binding: ActivityRegisBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.btnSubmit.setOnClickListener{
            val signUsername = binding.regisUsername.text.toString()
            val signPassword = binding.regisPassword.text.toString()
            signupDatabase(signUsername, signPassword)
        }
        binding.btnPunyaAkun.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signupDatabase(username: String, password: String){
        val insertedRowId = databaseHelper.insertUser(username, password)
        if (insertedRowId != -1L){
            Toast.makeText(this, "Anda berhasil Mendaftar", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }else {
            Toast.makeText(this, "Anda gagal Mendaftar", Toast.LENGTH_SHORT).show()
        }
    }
}