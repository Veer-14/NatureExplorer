package com.example.natureexplorer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val items = listOf(
            NatureItem("Forest", "Beautiful green forest", R.drawable.nature),
            NatureItem("Lake", "Peaceful lake view", R.drawable.nature),
            NatureItem("Mountains", "Snowy mountains", R.drawable.nature)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NatureAdapter(items) { item ->

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("desc", item.description)
            intent.putExtra("image", item.image)

            startActivity(intent)
        }
    }
}