package com.cnsb.uts_pm_d_csrf

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var logoutButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chat)

        // Setup Toolbar (cukup sekali)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerViewChat)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dummyData = listOf(
            Chat("Grup D-CSRF", "Reminder: Meeting jam 19.00", "5m"),
            Chat("Dev Team", "Jangan lupa review PR Kotlin terbaru.", "10m"),
            Chat("Red Team", "Exploit baru untuk bypass login ditemukan!", "12m"),
            Chat("Blue Team", "SIEM log kita penuh. Siapa yang bisa bantu cek?", "15m"),
            Chat("CTF Squad", "Soal stegano udah ada di channel ya!", "18m"),
            Chat("Tools & Resources", "Burp Suite update versi pro minggu ini.", "20m"),
            Chat("AI Security", "Yuk coba automasi serangan pakai Python.", "25m"),
            Chat("Fikri", "Halo, sudah lihat materi baru?", "1h"),
            Chat("Nadia", "Bisa bantu review kode saya?", "1h"),
            Chat("Moderator", "Silakan isi form absensi minggu ini.", "2h"),
            Chat("Dina", "Gambarnya bisa di-upload ulang?", "3h"),
            Chat("Cyber Team", "Ada tools baru buat forensik nih!", "4h"),
            Chat("Andin", "Aku udah update layout-nya kak.", "5h"),
            Chat("Pak Dosen", "Jangan lupa deadline hari Jumat.", "6h"),
            Chat("Rani", "Sudah coba fitur login-nya?", "7h"),
            Chat("Admin", "Selamat datang di komunitas D-CSRF!", "8h"),
            Chat("Agung", "Besok kita diskusi tentang API ya.", "10h"),
            Chat("Kelompok 3", "Semua tugas sudah dikumpulkan.", "12h"),
            Chat("Joko", "Laporan sudah aku email barusan.", "14h"),
            Chat("Notifikasi Bot", "Kamu punya 3 pesan belum dibaca.", "16h"),
            Chat("Bot Reminder", "Backup database kamu sekarang.", "18h")
        )

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        chatAdapter = ChatAdapter(dummyData)
        recyclerView.adapter = chatAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("Menu", "Menu created")
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }
            R.id.action_materi -> {
                startActivity(Intent(this, MateriActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}