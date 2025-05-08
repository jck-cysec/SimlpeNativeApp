package com.cnsb.uts_pm_d_csrf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val listChat: List<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNamaPengirim)
        val tvPesan: TextView = view.findViewById(R.id.tvPesan)
        val tvWaktu: TextView = view.findViewById(R.id.tvWaktu)
        val imgProfile: ImageView = view.findViewById(R.id.imgProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = listChat[position]
        holder.tvNama.text = chat.nama
        holder.tvPesan.text = chat.pesanTerakhir
        holder.tvWaktu.text = chat.waktu
        holder.imgProfile.setImageResource(R.drawable.profile)
    }

    override fun getItemCount(): Int = listChat.size
}
