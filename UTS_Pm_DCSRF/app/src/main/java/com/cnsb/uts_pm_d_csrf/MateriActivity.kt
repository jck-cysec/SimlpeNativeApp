package com.cnsb.uts_pm_d_csrf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MateriActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var materiAdapter: MateriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        // === Tambahkan ini untuk toolbar ===
        val toolbar: Toolbar = findViewById(R.id.toolbarMateri)
        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerViewMateri)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        val dummyMateri = listOf(
            Materi(R.drawable.dkotlin, "Dasar Kotlin", "Belajar dasar bahasa Kotlin untuk Android"),
            Materi(R.drawable.penetration, "Penetration Testing", "Langkah awal dalam Red Team operation"),
            Materi(R.drawable.incidentrespon, "Incident Response", "Langkah-langkah tim Blue Team saat terjadi serangan"),
            Materi(R.drawable.ctfforen, "CTF Forensik", "Cara membaca metadata dan analisis file mencurigakan"),
            Materi(R.drawable.cytools, "Cyber Tools", "Tool open source untuk pentest & monitoring jaringan"),
            Materi(R.drawable.sqlinject, "SQL Injection", "Cara kerja dan pencegahan serangan injeksi SQL"),
            Materi(R.drawable.androidsec, "Android Security", "Dasar keamanan aplikasi mobile dan pengetesan APK"),
            Materi(R.drawable.seccoding, "Secure Coding", "Tips coding aman agar tidak mudah diserang"),
            Materi(R.drawable.linuxforpen, "Linux for Pentest", "Perintah dasar Linux yang wajib untuk Red Team"),
            Materi(R.drawable.netmonir, "Network Monitoring", "Paket tools untuk memantau lalu lintas jaringan"),
            Materi(R.drawable.cyberthreat, "Threat Intelligence", "Mengenali dan merespon serangan dari threat actor"),
            Materi(R.drawable.devsecop, "DevSecOps", "Integrasi keamanan ke dalam pipeline DevOps"),
            Materi(R.drawable.chyrpto, "Cryptography", "Dasar enkripsi, dekripsi, dan hashing untuk pemula"),
            Materi(R.drawable.soialenginer, "Social Engineering", "Cara mengenali dan mencegah manipulasi psikologis"),
            Materi(R.drawable.bugboun, "Bug Bounty", "Panduan awal untuk menjadi pemburu celah keamanan")
        )


        materiAdapter = MateriAdapter(dummyMateri)
        recyclerView.adapter = materiAdapter
    }

//    // === Tangani tombol back dari toolbar ===
//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
}