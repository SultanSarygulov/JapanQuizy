package com.example.japanquizy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class KanaAdapter(private val kanasList: List<Kana>): RecyclerView.Adapter<KanaAdapter.KanaViewHolder>() {

    class KanaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val itemLetter: TextView = itemView.findViewById(R.id.item_letter)
        val itemSound: TextView = itemView.findViewById(R.id.item_sound)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).
            inflate(R.layout.item_kana, parent, false)

        return KanaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: KanaViewHolder, position: Int) {
        holder.itemLetter.text = kanasList[position].letter
        holder.itemSound.text = kanasList[position].sound
    }

    override fun getItemCount(): Int = kanasList.size
}