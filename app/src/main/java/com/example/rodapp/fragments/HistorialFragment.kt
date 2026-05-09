package com.example.rodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rodapp.R
import com.example.rodapp.SharedViewModel
import com.example.rodapp.SupabaseClient
import com.example.rodapp.adapters.HistorialAdapter
import com.example.rodapp.databinding.FragmentHistorialBinding
import com.example.rodapp.models.Combustible
import com.example.rodapp.models.HistorialItem
import com.example.rodapp.models.Mantenimiento
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.*

class HistorialFragment : Fragment() {

    private var _binding: FragmentHistorialBinding? = null
    private val binding get() = _binding!!
    private val sharedVm: SharedViewModel by activityViewModels()
    private lateinit var adapter: HistorialAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        cargarHistorial()
    }

    private fun setupRecyclerView() {
        adapter = HistorialAdapter(emptyList())
        binding.rvHistorial.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistorial.adapter = adapter
    }

    private fun cargarHistorial() {
        val motoId = sharedVm.motoId
        if (motoId == null) {
            binding.layoutEmptyState.visibility = View.VISIBLE
            binding.rvHistorial.visibility = View.GONE
            return
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                // Consultas paralelas
                val combustibleDeferred = async {
                    SupabaseClient.client.postgrest.from("registros_combustible")
                        .select {
                            filter { eq("moto_id", motoId) }
                        }.decodeList<Combustible>()
                }

                val mantenimientoDeferred = async {
                    SupabaseClient.client.postgrest.from("registros_mantenimiento")
                        .select {
                            filter { eq("moto_id", motoId) }
                        }.decodeList<Mantenimiento>()
                }

                val combustibles = combustibleDeferred.await()
                val mantenimientos = mantenimientoDeferred.await()

                val items = mutableListOf<HistorialItem>()
                items.addAll(combustibles.map { HistorialItem.GastoCombustible(it) })
                items.addAll(mantenimientos.map { HistorialItem.GastoMantenimiento(it) })

                // Ordenar por fecha descendente
                val sortedItems = items.sortedByDescending { it.fechaOrden }

                actualizarUI(sortedItems)
                calcularResumen(combustibles, mantenimientos)

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error al cargar historial", Toast.LENGTH_SHORT).show()
                binding.layoutEmptyState.visibility = View.VISIBLE
            }
        }
    }

    private fun actualizarUI(items: List<HistorialItem>) {
        if (items.isEmpty()) {
            binding.layoutEmptyState.visibility = View.VISIBLE
            binding.rvHistorial.visibility = View.GONE
        } else {
            binding.layoutEmptyState.visibility = View.GONE
            binding.rvHistorial.visibility = View.VISIBLE
            adapter.updateData(items)
        }
    }

    private fun calcularResumen(combustibles: List<Combustible>, mantenimientos: List<Mantenimiento>) {
        val totalMantenimientos = mantenimientos.size
        val totalGastoCombustible = combustibles.sumOf { it.costo }

        val locale = Locale.forLanguageTag("es-CO")
        val currencyFormat = NumberFormat.getCurrencyInstance(locale).apply {
            maximumFractionDigits = 0
        }

        binding.tvMantenimientoCount.text = totalMantenimientos.toString()
        binding.tvGastoTotal.text = if (totalGastoCombustible > 0) {
            currencyFormat.format(totalGastoCombustible)
        } else {
            getString(R.string.label_vacio_short)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
