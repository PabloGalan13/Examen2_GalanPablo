package com.example.examen2_galanpablo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Productos : AppCompatActivity() {
    var menu:ArrayList<Producto> = ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        var menuOption:String?= intent.getStringExtra("menuType")
        agregarProductos(imageView = findViewById(R.id.imageView),menuOption)
        var gridView: GridView =findViewById(R.id.gridView) as GridView
        var adaptador: ProductoAdapter= ProductoAdapter(this,menu)
        gridView.adapter=adaptador
    }
    fun agregarProductos(imageView: ImageView, option:String?){
        when(option){
            "Hot Drinks"->{
                imageView.setImageResource(R.drawable.colddrinks)
                menu.add(Producto("Latte", R.drawable.latte, 6.0))
                menu.add(Producto("Hot Chocolate", R.drawable.hotchocolate, 5.0))
                menu.add(Producto("Espresso", R.drawable.espresso, 4.0))
                menu.add(Producto("Chai Latte", R.drawable.chailatte, 6.0))
                menu.add(Producto("Capuccino", R.drawable.capuccino, 7.0))
                menu.add(Producto("American Coffe", R.drawable.americano, 2.0))
            }
            "Cold Drinks"->{
                imageView.setImageResource(R.drawable.colddrinks);
                menu.add(Producto("Caramel Frap", R.drawable.caramelfrap, 5.0));
                menu.add(Producto("Chocolate Frap", R.drawable.chocolatefrap, 6.0));
                menu.add(Producto("Cold Brew", R.drawable.coldbrew, 3.0));
                menu.add(Producto("Matcha Latte", R.drawable.matcha, 4.0));
                menu.add(Producto("Oreo Milkshake", R.drawable.oreomilkshake, 7.0));
                menu.add(Producto("Peanut Milkshake", R.drawable.peanutmilkshake, 7.0));
            }

            "Salties"->{
                imageView.setImageResource(R.drawable.salties);
                menu.add(Producto("Chicken Crepes", R.drawable.chickencrepes, 6.0));
                menu.add(Producto("Club Sandwich", R.drawable.clubsandwich, 5.0));
                menu.add(Producto("Panini", R.drawable.hampanini, 4.0));
                menu.add(Producto("Philly Cheese Steak", R.drawable.phillycheesesteak, 6.0));
                menu.add(Producto("Nachos", R.drawable.nachos, 7.0));
            }
            "Sweets"->{
                imageView.setImageResource(R.drawable.sweets);
                menu.add(Producto("Blueberry Cake", R.drawable.blueberrycake, 6.0));
                menu.add(Producto("Chocolate Cupcake", R.drawable.chocolatecupcake, 3.0));
                menu.add(Producto("Lemon Tartalette", R.drawable.lemontartalette, 4.0));
                menu.add(Producto("Red Velvet Cake", R.drawable.redvelvetcake, 6.0));
                menu.add(Producto("Cherry Cheesecake", R.drawable.strawberrycheesecake, 7.0));
                menu.add(Producto("Tiramisu", R.drawable.tiramisu, 6.0));
            }
        }
    }
    class ProductoAdapter: BaseAdapter {
        var productos = ArrayList<Producto>()
        var context: Context? = null

        constructor(context: Context, productos: ArrayList<Producto>) : super() {
            this.productos = productos
            this.context = context
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
            var producto = productos[pe]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.grid_item, null)
            var image: ImageView = vista.findViewById(R.id.productoImage)
            var nombre: TextView = vista.findViewById(R.id.productoName)

            image.setImageResource(producto.imageResId)
            nombre.setText(producto.name)

            image.setOnClickListener() {
                val intento = Intent(context, ProductoView::class.java)
                intento.putExtra("imagen", producto.imageResId)
                intento.putExtra("nombre", producto.name)
                intento.putExtra("precio", producto.precio)
                context!!.startActivity(intento)
            }
            return vista
        }
    }
}