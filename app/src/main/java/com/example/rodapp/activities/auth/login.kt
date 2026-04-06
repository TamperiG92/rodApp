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
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
