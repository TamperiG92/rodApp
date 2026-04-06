package com.example.rodapp.activities.inicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodapp.databinding.ActivityStartBinding
import com.example.rodapp.activities.auth.login

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

        // Configuración de botones (basado en criterios de interactividad visual)
        binding.btnIrLogin.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
    }
}
