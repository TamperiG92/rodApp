package com.example.rodapp.activities.inicio

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.rodapp.R

/**
 * firstActivity: Pantalla de Splash inicial de RodApp.
 */
class firstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        
        // Pausa de 2.5 segundos (2500 ms) antes de enviar a Start_activity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Start_activity::class.java))
            finish()
        }, 2500)
    }
}
