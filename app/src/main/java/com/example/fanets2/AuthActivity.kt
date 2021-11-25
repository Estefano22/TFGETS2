package com.example.fanets2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class AuthActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_FANETS2)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        auth = FirebaseAuth.getInstance();

        val entrar = findViewById<Button>(R.id.entrar)
        val registrar = findViewById<Button>(R.id.registrarse)
        val nombreUsuario = findViewById<EditText>(R.id.nombreUsuario)
        val Contrasenia = findViewById<EditText>(R.id.Contrasenia)

        entrar.setOnClickListener {


            if (nombreUsuario.text.trim().toString().isNotEmpty() || Contrasenia.text.trim().toString().isNotEmpty()){
                loginUsuario(nombreUsuario.text.trim().toString(),Contrasenia.text.trim().toString());

            }else{

                Toast.makeText(this, "Complete los Campos", Toast.LENGTH_LONG).show();

            }



        }

        registrar.setOnClickListener {

            if (nombreUsuario.text.trim().toString().isNotEmpty() || Contrasenia.text.trim().toString().isNotEmpty()) {
                crearUsuario(nombreUsuario.text.trim().toString(), Contrasenia.text.trim().toString())

                Toast.makeText(this, "Registrado con Excito", Toast.LENGTH_LONG).show()

            } else {

                Toast.makeText(this, "Complete los Campos", Toast.LENGTH_LONG).show()


            }
        }



    }

    private fun crearUsuario(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    Log.e("Task Message", "Successful");

                } else {

                    Log.e("Task Message", "Failed" + task.exception);

                }
            }

    }

    private fun loginUsuario(email: String, password: String){

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful){
                    val intent = Intent(this, SegundoActivity::class.java)
                    startActivity(intent)

                }else{
                    Toast.makeText(this, "Error !!"+task.exception, Toast.LENGTH_LONG).show()

                }
            }

    }
}