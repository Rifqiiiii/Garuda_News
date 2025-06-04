package com.example.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pas.R

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // Temukan ImageView dari layout activity_profile.xml
        val imageViewDashboard: ImageView = findViewById(R.id.imageView59)
        val imageViewBerita: ImageView = findViewById(R.id.imageView56)

        // Intent untuk imageView59 (tetap ke dashboard)
        imageViewDashboard.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }

        // Intent baru untuk imageView57 ke BertaActivity
        imageViewBerita.setOnClickListener {
            val intent = Intent(this, BertaActivity::class.java)
            startActivity(intent)
        }

        // Jika Anda ingin menambahkan Intent untuk ImageView lain, contoh:
        // val imageView55: ImageView = findViewById(R.id.imageView55)
        // imageView55.setOnClickListener {
        //     val intent = Intent(this, AnotherActivity::class.java)
        //     startActivity(intent)
        // }
    }
}