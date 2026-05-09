package com.example.rodapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rodapp.R
import com.example.rodapp.databinding.RowActividadLlenoBinding
import com.example.rodapp.models.HistorialItem
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class HistorialAdapter(private var items: List<HistorialItem>) :
    RecyclerView.Adapter<HistorialAdapter.ViewHolder>() {

    class ViewHolder(val binding: RowActividadLlenoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowActividadLlenoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale("es", "CO")).apply {
            maximumFractionDigits = 0
        }

        when (item) {
            is HistorialItem.GastoCombustible -> {
                holder.binding.apply {
                    // Usando ic_menu_today como placeholder ya que ic_combustible no existe
                    imgTipo.setImageResource(android.R.drawable.ic_menu_today) 
                    imgTipo.backgroundTintList = ContextCompat.getColorStateList(context, R.color.cyan_primary)
                    
                    txtTitulo.text = "Tanqueo: ${item.data.tipo_gasolina}"
                    txtSubtitulo.text = "${item.data.kilometraje} km • ${formatFecha(item.data.created_at)}"
                    txtMonto.text = currencyFormat.format(item.data.costo)
                }
            }
            is HistorialItem.GastoMantenimiento -> {
                holder.binding.apply {
                    // Usando ic_menu_manage como placeholder
                    imgTipo.setImageResource(android.R.drawable.ic_menu_manage)
                    imgTipo.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_blue)
                    
                    txtTitulo.text = item.data.tipo
                    txtSubtitulo.text = "${item.data.kilometraje} km • ${formatFecha(item.data.fecha)}"
                    txtMonto.text = "Mantenimiento" 
                }
            }
        }
    }

    override fun getItemCount() = items.size

    fun updateData(newItems: List<HistorialItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    private fun formatFecha(fechaIso: String): String {
        return try {
            // Maneja formatos como "2024-05-04" o "2024-05-04T12:00:00Z"
            val inputPart = fechaIso.substringBefore("T")
            val isoFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = isoFormat.parse(inputPart)
            val displayFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            displayFormat.format(date!!)
        } catch (e: Exception) {
            fechaIso
        }
    }
}
