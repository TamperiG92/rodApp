package com.example.rodapp.activities.inicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodapp.databinding.ActivityStartBinding
import com.example.rodapp.activities.auth.login
import com.example.rodapp.activities.auth.register_user

/**
 * Start_activity: Pantalla de bienvenida de RodApp.
 * Permite al usuario elegir entre iniciar sesión o registrarse.
 */
class Start_activity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de botones
        binding.btnIrLogin.setOnClickListener {
            // "Comenzar" ahora redirige a la pantalla de Login
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        binding.btnIrRegistro.setOnClickListener {
            startActivity(Intent(this, register_user::class.java))
        }
    }
}
