package com.example.fanets2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entrar = findViewById<Button>(R.id.entrar)

        entrar.setOnClickListener {
            val intent = Intent(this,SegundoActivity::class.java)
            startActivity(intent)
        }

        var editText1 = findViewById<EditText>(R.id.nombreUsuario)
        var editText2 = findViewById<EditText>(R.id.Contrasenia)

        editText1.doAfterTextChanged {

            if (it.isNullOrBlank()){

            }
        }

    }


}