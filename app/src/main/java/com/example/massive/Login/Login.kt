package com.example.massive.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.Dashboard
import com.example.massive.ForgetPassword
import com.example.massive.Home
import com.example.massive.R
import com.example.massive.databinding.ActivityLoginBinding
import com.example.massive.retro.Retro
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import retrofit2.Callback

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.btnLogin.setOnClickListener{
            val loginUsername = binding.etUsername.text.toString()
            val loginPassword = binding.etPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }

        val isInserted = databaseHelper.insertUser("jamal@gmail.com", "12345678")
/**
        if(isInserted){
            Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        } else {
           Toast.makeText(this, "Data gagal ditambahkan", Toast.LENGTH_SHORT).show()
      } **/
    }

    private fun loginDatabase(username: String, password: String){
        val userExists = databaseHelper.readUser(username, password)
        if (userExists){
            Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }

    /**
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name: EditText = findViewById(R.id.et_username)
        val send: View = binding.login

        send.setOnClickListener {
            val fragment = Home()
            val x = name.text.toString()
            val bundle = Bundle()
            bundle.putString("name", x)
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        binding.btnLupaSandi.setOnClickListener {
            startActivity(Intent(this, ForgetPassword::class.java))
        }
        binding.tvGoogle.setOnClickListener {
            signInWithGoogle()
        }
    }
    private fun signInWithGoogle() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleGoogleSignInResult(task)
        }
    }
    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            startActivity(Intent(this, Dashboard::class.java))
        } catch (e: ApiException) {
        }
    }
     **/
}
