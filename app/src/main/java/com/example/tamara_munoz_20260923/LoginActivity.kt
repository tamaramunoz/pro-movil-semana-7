package com.example.tamara_munoz_20260923

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        val edtClave = findViewById<EditText>(R.id.edtClave)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val usuarioIngresado = edtUsuario.text.toString()
            val claveIngresada = edtClave.text.toString()

            // validación para el login
            if (usuarioIngresado == "tamara" && claveIngresada == "123456") {
                val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("usuario", usuarioIngresado)
                editor.putString("clave", claveIngresada)
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}