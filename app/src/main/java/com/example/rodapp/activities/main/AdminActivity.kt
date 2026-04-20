package com.example.rodapp.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodapp.R
import com.example.rodapp.fragments.AdminUsersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.admin_bottom_navigation)
        
        // Empezar en la pestaña USERS visualmente (index 1)
        bottomNavigationView.selectedItemId = R.id.nav_admin_users
        
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.admin_fragment_container, AdminUsersFragment())
                .commit()
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_admin_users -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.admin_fragment_container, AdminUsersFragment())
                        .commit()
                    true
                }
                else -> false // Mocks for others
            }
        }
    }
}
