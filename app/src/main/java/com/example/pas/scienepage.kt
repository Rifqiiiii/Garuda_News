package com.example.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class scienepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scienepage)

        // ImageView pertama untuk pindah ke Activity A
        val imageViewToActivityA: ImageView = findViewById(R.id.imageView6)
        imageViewToActivityA.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

        // ImageView kedua untuk pindah ke Activity B
        val imageViewToActivityB: ImageView = findViewById(R.id.imageView04)
        imageViewToActivityB.setOnClickListener {
            val intent = Intent(this, search::class.java)
            startActivity(intent)
        }

        // ImageView ketiga untuk pindah ke Activity C
        val imageViewToActivityC: ImageView = findViewById(R.id.imageView09)
        imageViewToActivityC.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }

        // ImageView keempat untuk pindah ke Activity D
        val imageViewToActivityD: ImageView = findViewById(R.id.imageView54)
        imageViewToActivityD.setOnClickListener {
            val intent = Intent(this, health::class.java)
            startActivity(intent)
        }

        // ImageView kelima untuk pindah ke Activity E
        val imageViewToActivityE: ImageView = findViewById(R.id.imageView31)
        imageViewToActivityE.setOnClickListener {
            val intent = Intent(this, football::class.java)
            startActivity(intent)
        }
    }
}