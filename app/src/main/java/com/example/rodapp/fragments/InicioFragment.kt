package com.example.rodapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.rodapp.R
import com.example.rodapp.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!
    
    private var isMenuOpen = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabMain.setOnClickListener {
            toggleMenu()
        }

        binding.btnNuevoCombustible.setOnClickListener {
            findNavController().navigate(R.id.navigation_combustible)
            toggleMenu()
        }

        binding.btnNuevoMantenimiento.setOnClickListener {
            findNavController().navigate(R.id.navigation_mantenimiento)
            toggleMenu()
        }
    }

    private fun toggleMenu() {
        if (!isMenuOpen) {
            binding.fabMenu.visibility = View.VISIBLE
            binding.fabMain.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
            isMenuOpen = true
        } else {
            binding.fabMenu.visibility = View.GONE
            binding.fabMain.setImageResource(android.R.drawable.ic_input_add)
            isMenuOpen = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
