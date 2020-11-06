package com.ukcrimebrowser.android.domain.adapters

import com.ukcrimebrowser.android.presentation.crime.CrimeDetail
import com.ukcrimebrowser.android.presentation.map.CrimeMapFragment

/**
 * Adapter to keep implementation abstracted to the Application code base.
 */
interface MapAdapter {
    fun setMapView(mapFragment: CrimeMapFragment)
    fun setOnLocationChangedListener(listener: MapListener)
    fun requestLocationUpdate()
    fun markCrimes(crimeDetails: List<CrimeDetail>, reset: Boolean = false)

    interface MapListener {
        fun onLocationChanged(latitude: Double, longitude: Double)
        fun onMarkerSelected(crimeDetail: CrimeDetail)
    }
}