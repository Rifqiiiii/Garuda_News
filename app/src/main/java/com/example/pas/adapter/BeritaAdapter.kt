package com.example.pas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pas.R
import com.example.pas.model.Berita

class BeritaAdapter(
    private val beritaList: List<Berita>,
    private val onItemClick: (Berita) -> Unit
) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val berita = beritaList[position]
        holder.tvJenisBerita.text = berita.jenis_berita
        holder.tvWaktuRilis.text = berita.waktu_rilis
        holder.tvPenulis.text = berita.penulis

        // Klik item untuk membuka EditBeritaActivity
        holder.itemView.setOnClickListener {
            onItemClick(berita)
        }
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvJenisBerita: TextView = itemView.findViewById(R.id.tvJenisBerita)
        val tvWaktuRilis: TextView = itemView.findViewById(R.id.tvWaktuRilis)
        val tvPenulis: TextView = itemView.findViewById(R.id.tvPenulis)
    }
}