package com.example.rodapp.activities.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rodapp.databinding.ActivityRegisterUserBinding

/**
 * register_user: Actividad para el registro de nuevos usuarios en RodApp.
 */
class register_user : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCrearCuenta.setOnClickListener {
            // Validación visual del CheckBox de términos y condiciones
            if (binding.checkTerminos.isChecked) {
                Toast.makeText(this, "¡Cuenta Creada!", Toast.LENGTH_SHORT).show()
                finish() // Regresa al login o pantalla anterior
            } else {
                Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
            }
        }

        // Listener para volver al login si ya tiene cuenta
        binding.btnIrLogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            // Usamos FLAG_ACTIVITY_CLEAR_TOP para que si ya existe una instancia de login, se use esa.
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        // Listener para el botón de volver (flecha)
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
