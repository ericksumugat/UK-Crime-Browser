package com.ukcrimebrowser.android.data.repositories

import com.ukcrimebrowser.android.data.source.contract.CrimeStore
import com.ukcrimebrowser.android.data.source.local.CrimeEntity
import com.ukcrimebrowser.android.data.source.remote.response.toCrimeEntity
import com.ukcrimebrowser.android.domain.repositories.CrimeRepository
import io.reactivex.Observable
import javax.inject.Inject

class CrimeDataRepository @Inject constructor(private val crimeStore: CrimeStore) :
    CrimeRepository {


    override fun getCrimesByAngles(
        date: String,
        latitude: Double,
        longitude: Double
    ): Observable<List<CrimeEntity>> {
        // Usually I do data persistence here after the response arrived.
        return crimeStore.getCrimesByAngles(date, latitude = latitude, longitude = longitude)
            .map { it.map { crimeResponse -> crimeResponse.toCrimeEntity() } }
    }
}