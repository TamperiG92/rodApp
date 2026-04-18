package com.example.rodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rodapp.databinding.FragmentNuevoDocumentoBinding

class NuevoDocumentoFragment : Fragment() {

    private var _binding: FragmentNuevoDocumentoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNuevoDocumentoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackNuevoDoc.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnGuardarNuevoDoc.setOnClickListener {
            // Lógica para guardar el documento personalizado
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
