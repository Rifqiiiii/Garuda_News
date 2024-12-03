package com.example.pas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Temukan tombol dari layout activity_main.xml
        val buttonStart: Button = findViewById(R.id.btnLogin)

        // Set onClickListener untuk pindah ke SecondActivity
        buttonStart.setOnClickListener {
            // Membuat intent untuk berpindah dari MainActivity ke SecondActivity
            val intent = Intent(this, dashboard::class.java)
            // Mulai activity baru
            startActivity(intent)
            }
        }
    }