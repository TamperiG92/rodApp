package com.example.rodapp.activities.inicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * firstActivity: Pantalla de Splash inicial de RodApp.
 */
class firstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Por ahora, redirige directamente a la pantalla de bienvenida (Start_activity)
        startActivity(Intent(this, Start_activity::class.java))
        finish()
    }
}
