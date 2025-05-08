package com.cnsb.uts_pm_d_csrf

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: ImageButton
    private lateinit var registerButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Cek apakah sudah ada session login
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            startActivity(Intent(this, ListChatActivity::class.java))
            finish()
        }

        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.btnLogin)
        registerButton = findViewById(R.id.btnRegister)

        loginButton.setOnClickListener {
            val emailInput = emailEditText.text.toString().trim()
            val passwordInput = passwordEditText.text.toString().trim()

            val savedEmail = sharedPreferences.getString("email", null)
            val savedPassword = sharedPreferences.getString("password", null)

            if (emailInput == savedEmail && passwordInput == savedPassword) {
                // Set status login menjadi true
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListChatActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}

