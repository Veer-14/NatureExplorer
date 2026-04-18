package com.example.natureexplorer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.navigationView)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open, R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.gallery -> {
                    startActivity(Intent(this, GalleryActivity::class.java))
                }

                // 📧 IMPLICIT INTENT (EMAIL)
                R.id.favorites -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "message/rfc822"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("test@email.com"))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Nature Explorer App")
                    startActivity(intent)
                }

                // 🌐 IMPLICIT INTENT (WEBSITE)
                R.id.settings -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                    startActivity(intent)
                }
            }

            drawerLayout.closeDrawers()
            true
        }
    }
}