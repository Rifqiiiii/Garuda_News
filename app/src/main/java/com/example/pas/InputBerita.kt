package com.example.pas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pas.R
import com.example.pas.model.Berita
import com.google.firebase.firestore.FirebaseFirestore

class InputBerita : AppCompatActivity() {

    private lateinit var etJenisBerita: EditText
    private lateinit var etWaktuRilis: EditText
    private lateinit var etPenulis: EditText
    private lateinit var btnTulisBerita: Button
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_berita)

        // Initialize views based on the XML
        etJenisBerita = findViewById(R.id.etJenisBerita)
        etWaktuRilis = findViewById(R.id.etWaktuRilis)
        etPenulis = findViewById(R.id.etPenulis)
        btnTulisBerita = findViewById(R.id.btnTulisBerita)

        // Set click listener for the button
        btnTulisBerita.setOnClickListener {
            saveBerita()
        }
    }

    private fun saveBerita() {
        val jenisBerita = etJenisBerita.text.toString().trim()
        val waktuRilis = etWaktuRilis.text.toString().trim()
        val penulis = etPenulis.text.toString().trim()

        // Basic validation
        if (jenisBerita.isEmpty() || waktuRilis.isEmpty() || penulis.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            return
        }

        val berita = Berita(id = "", jenis_berita = jenisBerita, waktu_rilis = waktuRilis, penulis = penulis)

        firestore.collection("berita").add(berita)
            .addOnSuccessListener {
                Toast.makeText(this, "Berita berhasil disimpan", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Gagal menyimpan berita", Toast.LENGTH_SHORT).show()
            }
    }
}