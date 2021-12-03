package com.example.fanets2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CarritoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carritocompra)

        val Pagar = findViewById<Button>(R.id.pagar)


        Pagar.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/es/home"))
            startActivity(i)
        }


    }
}