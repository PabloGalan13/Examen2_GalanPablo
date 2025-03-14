package com.example.examen2_galanpablo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductoView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_producto_view)

        val imagen: ImageView =findViewById(R.id.imagen)
        val nombre: TextView =findViewById(R.id.nombreProducto)
        val precio: TextView =findViewById(R.id.precioProducto)

        val bundle=intent.extras
        if (bundle!=null){
            imagen.setImageResource(bundle.getInt("imagen"))
            nombre.setText(bundle.getString("nombre"))
            precio.text = "$" + bundle.getDouble("precio").toString()
        }
    }
}