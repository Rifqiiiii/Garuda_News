package com.example.pas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pas.adapter.BeritaAdapter
import com.example.pas.model.Berita
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.example.pas.R

class BertaActivity : AppCompatActivity() {

    private lateinit var rvBerita: RecyclerView
    private lateinit var btnAddBerita: Button
    private lateinit var beritaAdapter: BeritaAdapter
    private val beritaList = mutableListOf<Berita>()
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_berta)

        firestore = FirebaseFirestore.getInstance()

        rvBerita = findViewById(R.id.rvBerita)
        btnAddBerita = findViewById(R.id.btnAddBerita)

        // Inisialisasi BeritaAdapter dengan fungsi klik item
        beritaAdapter = BeritaAdapter(
            beritaList,
            onItemClick = { berita ->
                val intent = Intent(this, EditBeritaActivity::class.java)
                intent.putExtra("beritaId", berita.id)
                startActivityForResult(intent, REQUEST_CODE_EDIT_BERITA)
            }
        )
        rvBerita.layoutManager = LinearLayoutManager(this)
        rvBerita.adapter = beritaAdapter

        btnAddBerita.setOnClickListener {
            val intent = Intent(this, InputBerita::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_BERITA)
        }

        loadBeritaData()
    }

    private fun loadBeritaData() {
        firestore.collection("berita").get()
            .addOnSuccessListener { documents ->
                beritaList.clear()
                Log.d("BeritaActivity", "Jumlah dokumen: ${documents.size()}")
                for (document in documents) {
                    val berita = document.toObject(Berita::class.java)
                    berita.id = document.id
                    Log.d("BeritaActivity", "Berita: $berita")
                    beritaList.add(berita)
                }
                beritaAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Gagal memuat data berita: ${exception.message}", Toast.LENGTH_LONG).show()
                Log.e("BeritaActivity", "Error memuat data: $exception")
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == REQUEST_CODE_ADD_BERITA || requestCode == REQUEST_CODE_EDIT_BERITA) && resultCode == RESULT_OK) {
            loadBeritaData()
        }
    }

    companion object {
        const val REQUEST_CODE_ADD_BERITA = 1
        const val REQUEST_CODE_EDIT_BERITA = 2
    }
}