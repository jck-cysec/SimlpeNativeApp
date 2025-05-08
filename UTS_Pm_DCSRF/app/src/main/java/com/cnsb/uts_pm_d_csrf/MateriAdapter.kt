package com.cnsb.uts_pm_d_csrf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MateriAdapter(private val listMateri: List<Materi>) :
    RecyclerView.Adapter<MateriAdapter.MateriViewHolder>() {

    class MateriViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMateri: ImageView = view.findViewById(R.id.imgMateri)
        val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        val tvSubjudul: TextView = view.findViewById(R.id.tvSubjudul)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_materi, parent, false)
        return MateriViewHolder(view)
    }

    override fun onBindViewHolder(holder: MateriViewHolder, position: Int) {
        val materi = listMateri[position]
        holder.imgMateri.setImageResource(materi.imageResId)
        holder.tvJudul.text = materi.judul
        holder.tvSubjudul.text = materi.subjudul
    }

    override fun getItemCount(): Int = listMateri.size
}