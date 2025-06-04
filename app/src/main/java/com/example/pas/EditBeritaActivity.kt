package com.example.pas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pas.model.Berita
import com.google.firebase.firestore.FirebaseFirestore
import com.example.pas.R

class EditBeritaActivity : AppCompatActivity() {

    private lateinit var etJenisBerita: EditText
    private lateinit var etWaktuRilis: EditText
    private lateinit var etPenulis: EditText
    private lateinit var btnSimpan: Button
    private lateinit var btnHapus: Button
    private lateinit var firestore: FirebaseFirestore
    private var beritaId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_berita)

        firestore = FirebaseFirestore.getInstance()

        etJenisBerita = findViewById(R.id.etJenisBerita)
        etWaktuRilis = findViewById(R.id.etWaktuRilis)
        etPenulis = findViewById(R.id.etPenulis)
        btnSimpan = findViewById(R.id.btnSimpan)
        btnHapus = findViewById(R.id.btnHapus)

        // Ambil beritaId dari Intent
        beritaId = intent.getStringExtra("beritaId")
        if (beritaId == null) {
            Toast.makeText(this, "ID berita tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Muat data berita dari Firestore
        loadBeritaData()

        btnSimpan.setOnClickListener {
            updateBerita()
        }

        btnHapus.setOnClickListener {
            deleteBerita()
        }
    }

    private fun loadBeritaData() {
        beritaId?.let { id ->
            firestore.collection("berita").document(id).get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        val berita = document.toObject(Berita::class.java)
                        berita?.let {
                            etJenisBerita.setText(it.jenis_berita)
                            etWaktuRilis.setText(it.waktu_rilis)
                            etPenulis.setText(it.penulis)
                        }
                    } else {
                        Toast.makeText(this, "Berita tidak ditemukan", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Gagal memuat data: ${exception.message}", Toast.LENGTH_LONG).show()
                }
        }
    }

    private fun updateBerita() {
        val jenisBerita = etJenisBerita.text.toString().trim()
        val waktuRilis = etWaktuRilis.text.toString().trim()
        val penulis = etPenulis.text.toString().trim()

        if (jenisBerita.isEmpty() || waktuRilis.isEmpty() || penulis.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            return
        }

        val updatedBerita = Berita(
            id = beritaId ?: "",
            jenis_berita = jenisBerita,
            waktu_rilis = waktuRilis,
            penulis = penulis
        )

        beritaId?.let { id ->
            firestore.collection("berita").document(id).set(updatedBerita)
                .addOnSuccessListener {
                    Toast.makeText(this, "Berita berhasil diperbarui", Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK)
                    finish()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Gagal memperbarui berita: ${exception.message}", Toast.LENGTH_LONG).show()
                }
        }
    }

    private fun deleteBerita() {
        beritaId?.let { id ->
            android.app.AlertDialog.Builder(this)
                .setTitle("Hapus Berita")
                .setMessage("Apakah Anda yakin ingin menghapus berita ini?")
                .setPositiveButton("Ya") { _, _ ->
                    firestore.collection("berita").document(id).delete()
                        .addOnSuccessListener {
                            Toast.makeText(this, "Berita berhasil dihapus", Toast.LENGTH_SHORT).show()
                            setResult(RESULT_OK)
                            finish()
                        }
                        .addOnFailureListener { exception ->
                            Toast.makeText(this, "Gagal menghapus berita: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}