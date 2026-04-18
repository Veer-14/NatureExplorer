package com.example.natureexplorer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NatureAdapter(
    private val items: List<NatureItem>,
    private val onClick: (NatureItem) -> Unit
) : RecyclerView.Adapter<NatureAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.cardImage)
        val title: TextView = view.findViewById(R.id.cardTitle)
        val desc: TextView = view.findViewById(R.id.cardDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.desc.text = item.description

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount() = items.size
}