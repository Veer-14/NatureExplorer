package com.example.natureexplorer

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val image = findViewById<ImageView>(R.id.detailImage)
        val title = findViewById<TextView>(R.id.detailTitle)
        val desc = findViewById<TextView>(R.id.detailDesc)

        title.text = intent.getStringExtra("title")
        desc.text = intent.getStringExtra("desc")
        image.setImageResource(intent.getIntExtra("image", 0))
    }
}