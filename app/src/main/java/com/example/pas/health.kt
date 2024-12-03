package com.example.pas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class health : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)

        // ImageView pertama untuk pindah ke Activity A
        val imageViewToActivityA: ImageView = findViewById(R.id.imageView5)
        imageViewToActivityA.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

        // ImageView kedua untuk pindah ke Activity B
        val imageViewToActivityB: ImageView = findViewById(R.id.imageView8)
        imageViewToActivityB.setOnClickListener {
            val intent = Intent(this, search::class.java)
            startActivity(intent)
        }

        // ImageView ketiga untuk pindah ke Activity C
        val imageViewToActivityC: ImageView = findViewById(R.id.imageView39)
        imageViewToActivityC.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }

        // ImageView keempat untuk pindah ke Activity D
        val imageViewToActivityD: ImageView = findViewById(R.id.imageView40)
        imageViewToActivityD.setOnClickListener {
            val intent = Intent(this, scienepage::class.java)
            startActivity(intent)
        }

        // ImageView kelima untuk pindah ke Activity E
        val imageViewToActivityE: ImageView = findViewById(R.id.imageView41)
        imageViewToActivityE.setOnClickListener {
            val intent = Intent(this, football::class.java)
            startActivity(intent)
        }
    }
}