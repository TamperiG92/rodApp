package com.example.rodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rodapp.R
import com.example.rodapp.databinding.FragmentGarajeDocumentosBinding

class GarajeDocumentosFragment : Fragment() {

    private var _binding: FragmentGarajeDocumentosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGarajeDocumentosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Navegación al formulario de SOAT
        binding.cardSoat.setOnClickListener {
            findNavController().navigate(R.id.navigation_registro_soat)
        }

        // Navegación al formulario de RTM
        binding.cardRtm.setOnClickListener {
            findNavController().navigate(R.id.navigation_registro_rtm)
        }

        // Navegación para añadir otro documento (Documentos Adicionales)
        binding.cardOtroDoc.setOnClickListener {
            findNavController().navigate(R.id.navigation_nuevo_documento)
        }

        // Configuración de ajustes (Perfil)
        binding.btnSettingsGaraje.setOnClickListener {
            findNavController().navigate(R.id.navigation_perfil)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
