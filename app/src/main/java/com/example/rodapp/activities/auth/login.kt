package com.example.rodapp.activities.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodapp.activities.main.MainActivity
import com.example.rodapp.databinding.ActivityLoginBinding

/**
 * login: Actividad para la autenticación de usuarios de RodApp.
 */
class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // Interactividad visual: Salto a la actividad principal
            // Usamos la MainActivity correcta ubicada en el paquete activities.main
            val intent = Intent(this, com.example.rodapp.activities.main.MainActivity::class.java)
            // Aseguramos que se limpie la pila de actividades
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        binding.btnIrRegistro.setOnClickListener {
            startActivity(Intent(this, register_user::class.java))
        }
    }
}
