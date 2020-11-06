package com.ukcrimebrowser.android.domain.usecases

import com.ukcrimebrowser.android.presentation.crime.CrimeDetail
import io.reactivex.Observable

interface CrimeProvider {

    fun getCrimesByAngles(
        date: String,
        latitude: Double,
        longitude: Double
    ): Observable<List<CrimeDetail>>
}