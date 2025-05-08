package com.cnsb.uts_pm_d_csrf

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var namaEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginLink: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Inisialisasi view
        namaEditText = findViewById(R.id.editTextNama)
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        registerButton = findViewById(R.id.btnRegister)
        loginLink = findViewById(R.id.tvLoginLink)

        // Tombol Daftar diklik
        registerButton.setOnClickListener {
            val nama = namaEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                // Simpan data user ke SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("email", email)
                editor.putString("password", password)
                editor.putBoolean("isLoggedIn", false) // Pastikan status login masih false
                editor.apply()

                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                Log.d("Reg", "reg success")

                // Kembali ke halaman login
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        loginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}


