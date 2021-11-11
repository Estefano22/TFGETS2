package com.example.fanets2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entrar = findViewById<Button>(R.id.entrar)

        entrar.setOnClickListener {
            val intent = Intent(this,SegundoActivity::class.java)
            startActivity(intent)
        }

    }


}