package com.example.massive.Login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.Dashboard
import com.example.massive.ForgetPassword
import com.example.massive.databinding.ActivityLoginBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Callback
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    private val RC_SIGN_IN = 9001
    private var errorJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.btnLogin.setOnClickListener {
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

        binding.btnBelumPunyaAkun.setOnClickListener {
            val intent = Intent(this, Regis::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLupaSandi.setOnClickListener {
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validateUser(etUsername: TextInputEditText, etPassword: TextInputEditText) {
        val userNameExist = databaseHelper.readUserName(etUsername.text.toString())
        val userPasswordExist = databaseHelper.readUserPassword(etPassword.text.toString())

        clearError()

        if (etUsername.text.isNullOrEmpty()) {
            binding.textEmailViewError.visibility = View.VISIBLE
            binding.textEmailViewError.text = "Masukkan Email yang valid!"
        } else if (userNameExist) {
            binding.textEmailViewError.visibility = View.VISIBLE
            binding.textEmailViewError.text = "Email Anda Salah, Coba lagi!"
        } else {
            binding.textEmailViewError.visibility = View.GONE

        }

        if (etPassword.text.isNullOrEmpty()) {
            binding.textPasswordViewError.visibility = View.VISIBLE
            binding.textPasswordViewError.text = "Masukkan Password yang valid!"
        } else if (userPasswordExist) {
            binding.textPasswordViewError.visibility = View.VISIBLE
            binding.textPasswordViewError.text = "Password Anda Salah, Coba Lagi!"

        } else if (etUsername.text!!.isNotEmpty()) {
            binding.textEmailViewError.visibility = View.GONE

        }

        // Kondisi baru untuk mengecek apakah nama pengguna dan kata sandi kosong atau tidak
        if (etUsername.text.toString().isEmpty() && etPassword.text.toString().isEmpty()) {
            binding.textEmailViewError.visibility = View.VISIBLE
            binding.textEmailViewError.text = "Email Tidak Boleh Kosong"
            binding.textPasswordViewError.visibility = View.VISIBLE
            binding.textPasswordViewError.text = "Password Tidak Boleh Kosong"
        }
    }

    private fun loginDatabase(username: String, password: String) {
        val userExists = databaseHelper.readUser(username, password)
        if (userExists) {
            Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        } else {
            validateUser(binding.etUsername, binding.etPassword)
            binding.textViewError.visibility = View.VISIBLE
            binding.textViewError.text = "Perbaiki Email atau Passwordnya!"
        }

        errorJob = CoroutineScope(Dispatchers.Main).launch {
            delay(4000)
            clearError()
        }
    }

    private fun clearError() {
        errorJob?.cancel()
        binding.textEmailViewError.visibility = View.GONE
        binding.textPasswordViewError.visibility = View.GONE
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
