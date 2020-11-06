package com.ukcrimebrowser.android.domain.usecases

import com.ukcrimebrowser.android.domain.repositories.CrimeRepository
import com.ukcrimebrowser.android.presentation.crime.CrimeDetail
import com.ukcrimebrowser.android.presentation.crime.toCrimeDetail
import io.reactivex.Observable
import javax.inject.Inject

class UkCrimeProvider @Inject constructor(private val crimeRepository: CrimeRepository,): CrimeProvider {

    override fun getCrimesByAngles(
        date: String,
        latitude: Double,
        longitude: Double
    ): Observable<List<CrimeDetail>> {
        return crimeRepository.getCrimesByAngles(date, latitude, longitude)
            .map { it.map { crimeEntity ->  crimeEntity.toCrimeDetail()} }
    }
}