package com.ukcrimebrowser.android.domain.repositories

import com.ukcrimebrowser.android.data.source.local.CrimeEntity
import io.reactivex.Observable

interface CrimeRepository {
    fun getCrimesByAngles(
        date: String,
        latitude: Double,
        longitude: Double
    ): Observable<List<CrimeEntity>>
}