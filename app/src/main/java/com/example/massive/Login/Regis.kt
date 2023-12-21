package com.example.massive.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
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
        binding.regisUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                validateEmail()
            }

            override fun afterTextChanged(s: Editable) {}
        })

        binding.regisPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                validatePassword()
            }
            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun validateEmail() {
        val emailInput = binding.regisUsername.text.toString().trim()
        if (emailInput.isEmpty()) {
            binding.textRegisEmailViewError.text = "Email harus diisi"
            binding.textRegisEmailViewError.visibility = View.VISIBLE
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            binding.textRegisEmailViewError.text = "Email tidak valid"
            binding.textRegisEmailViewError.visibility = View.VISIBLE
        } else {
            binding.textRegisEmailViewError.visibility = View.GONE
        }
    }

    private fun validatePassword() {
        val passwordInput = binding.regisPassword.text.toString().trim()
        if (passwordInput.isEmpty()) {
            binding.textRegisPasswordViewError.text = "Password harus diisi"
            binding.textRegisPasswordViewError.visibility = View.VISIBLE
        } else if (passwordInput.length < 8) {
            binding.textRegisPasswordViewError.text = "Password harus minimal 8 karakter"
            binding.textRegisPasswordViewError.visibility = View.VISIBLE
        } else {
            binding.textRegisPasswordViewError.visibility = View.GONE
        }
    }

    private fun validateEmailAndPassword() {
        validateEmail()
        validatePassword()
    }

    private fun signupDatabase(username: String, password: String){
        validateEmailAndPassword()

        if (binding.textRegisEmailViewError.visibility == View.VISIBLE || binding.textRegisPasswordViewError.visibility == View.VISIBLE){
            Toast.makeText(this, "Mohon periksa kembali input anda", Toast.LENGTH_SHORT).show()
            return
        }

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