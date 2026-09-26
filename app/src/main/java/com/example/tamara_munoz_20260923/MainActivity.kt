package com.example.tamara_munoz_20260923

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (!isLoggedIn) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            return
        }

        setContentView(R.layout.activity_main)

        val txtBienvenido = findViewById<TextView>(R.id.txtBienvenido)
        val usuario = sharedPreferences.getString("usuario", "Usuario")
        txtBienvenido.text = "Bienvenido: $usuario"

        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        InvocaApiBitcoin { listaDatos ->
            val listView = findViewById<ListView>(R.id.listaBitcoin)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos)
            listView.adapter = adapter
        }.execute()
    }
}