package com.example.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Temukan ImageView dari layout activity_main.xml
        val imageView: ImageView = findViewById(R.id.imageView010)

        // Set onClickListener untuk pindah ke SecondActivity
        imageView.setOnClickListener {
            // Membuat intent untuk berpindah dari MainActivity ke SecondActivity
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }
    }
}