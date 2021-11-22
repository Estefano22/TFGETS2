package com.example.fanets2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.google.firebase.analytics.FirebaseAnalytics


class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Integracion de Firebase")
        analytics.logEvent("InitScreen",bundle)

        val entrar = findViewById<Button>(R.id.entrar)

        entrar.setOnClickListener {
            val intent = Intent(this,SegundoActivity::class.java)
            startActivity(intent)


        }

        val b = findViewById<Button>(R.id.registrarse)
        b.setOnClickListener {
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)

        }

        var editText1 = findViewById<EditText>(R.id.nombreUsuario)
        var editText2 = findViewById<EditText>(R.id.Contrasenia)

        editText1.doAfterTextChanged {

            if (it.isNullOrBlank()){
                editText1
            }
        }

    }




}