package com.ukcrimebrowser.android.domain.adapters

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.ukcrimebrowser.android.presentation.crime.CrimeDetail
import com.ukcrimebrowser.android.presentation.map.CrimeMapFragment
import javax.inject.Inject


class GoogleMapAdapter @Inject constructor() : MapAdapter, OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    private var googleMap: GoogleMap? = null
    private var listener: MapAdapter.MapListener? = null

    private val defaultLoc = LatLng(51.509865, -0.118092)

    private val markerMap = mutableMapOf<Marker, Int>()
    private val crimeDetailsMap = mutableMapOf<Int, CrimeDetail>()

    override fun setMapView(mapFragment: CrimeMapFragment) {
        mapFragment.getMapAsync(this)
    }

    override fun setOnLocationChangedListener(listener: MapAdapter.MapListener) {
        this.listener = listener
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap
        this.googleMap?.setOnMarkerClickListener(this)
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(defaultLoc))
        googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLoc, 10.0f))
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val crimeId = markerMap[marker]
        val crimeDetail = crimeDetailsMap[crimeId]

        crimeDetail?.let {
            listener?.onMarkerSelected(crimeDetail)
        }

        marker?.let {
            if (it.isInfoWindowShown) it.hideInfoWindow() else it.showInfoWindow()
        }

        return true
    }

    override fun requestLocationUpdate() {
        googleMap?.let {
            val centerLatLng = it.projection.visibleRegion.latLngBounds.center
            listener?.onLocationChanged(centerLatLng.latitude, centerLatLng.longitude)
        }
    }


    override fun markCrimes(crimeDetails: List<CrimeDetail>, reset: Boolean) {

        if (reset) {
            markerMap.clear()
            crimeDetailsMap.clear()
            googleMap?.clear()
        }

        crimeDetailsMap.putAll(crimeDetails.map { it.id to it }.toMap())

        crimeDetails.forEach {
            if (!markerMap.containsValue(it.id)) {
                // Add only if not yet existing on the map
                val lat = it.latitude.toDouble()
                val lng = it.longitude.toDouble()
                addMarker(lat, lng, it.streetName)?.let { marker ->
                    markerMap[marker] = it.id
                }
            }
        }
    }

    private fun addMarker(
        latitude: Double,
        longitude: Double,
        title: String
    ): Marker? {
        return googleMap?.addMarker(
            MarkerOptions()
                .position(LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title)
        )
    }
}