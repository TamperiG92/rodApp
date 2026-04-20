package com.example.rodapp.fragments

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rodapp.R
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapaFragment : Fragment() {

    private lateinit var map: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicializar configuración de OSM (Previene errores de descarga de texturas)
        Configuration.getInstance().load(context, androidx.preference.PreferenceManager.getDefaultSharedPreferences(requireContext()))

        val view = inflater.inflate(R.layout.fragment_mapa, container, false)
        map = view.findViewById(R.id.mapview)

        setupMap()
        addMockMarkers()

        return view
    }

    private fun setupMap() {
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        
        // Centrar coordenada de prueba (Bogotá)
        val startPoint = GeoPoint(4.6097, -74.0817)
        map.controller.setZoom(15.0)
        map.controller.setCenter(startPoint)

        // *** DARK MODE MATRIX FILTER MAGIC ***
        // Invertir los colores del mapa para que logre la estetica Premium
        val inverseMatrix = ColorMatrix(
            floatArrayOf(
                -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
                0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
                0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
                0.0f, 0.0f, 0.0f, 1.0f, 0.0f
            )
        )
        // Reducir la saturación un poco para que el color Invertido no brille mucho 
        val destinationColorMatrix = ColorMatrix()
        destinationColorMatrix.setSaturation(0.2f)
        destinationColorMatrix.postConcat(inverseMatrix)
        
        val filter = ColorMatrixColorFilter(destinationColorMatrix)
        map.overlayManager.tilesOverlay.setColorFilter(filter)
    }

    private fun addMockMarkers() {
        // Añadir pines simulando que usamos los flotantes anteriores
        // Taller 
        val m1 = Marker(map)
        m1.position = GeoPoint(4.6110, -74.0820)
        m1.title = "Taller MotoTech"
        m1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        // Podríamos setear un drawable de tu APP como icono aca: m1.icon = context?.resources?.getDrawable(R.drawable.mi_icono)
        map.overlays.add(m1)

        // Parqueadero
        val m2 = Marker(map)
        m2.position = GeoPoint(4.6060, -74.0800)
        m2.title = "Parqueadero Central"
        m2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        map.overlays.add(m2)
    }

    override fun onResume() {
        super.onResume()
        map.onResume() 
    }

    override fun onPause() {
        super.onPause()
        map.onPause()  
    }
}
