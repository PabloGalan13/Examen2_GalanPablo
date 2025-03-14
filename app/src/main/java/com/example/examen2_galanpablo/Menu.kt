package com.example.examen2_galanpablo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSweets: Button = findViewById(R.id.button_sweets)
        val btnHotDrinks: Button = findViewById(R.id.button_hotDrinks)
        val btnColdDrinks: Button = findViewById(R.id.button_coldDrinks)
        val btnSalties: Button = findViewById(R.id.button_salties)

        btnSweets.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Sweets")
            startActivity(intent)
        }
        btnHotDrinks.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Hot Drinks")
            startActivity(intent)
        }
        btnColdDrinks.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Cold Drinks")
            startActivity(intent)
        }
        btnSalties.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Salties")
            startActivity(intent)
        }
    }
}