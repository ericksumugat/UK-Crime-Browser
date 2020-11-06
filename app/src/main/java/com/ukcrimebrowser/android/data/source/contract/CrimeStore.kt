package com.ukcrimebrowser.android.data.source.contract

import com.ukcrimebrowser.android.data.source.remote.response.CrimeResponse
import io.reactivex.Observable
import io.reactivex.Single

interface CrimeStore {

    fun getCrimesByAngles(
        date: String,
        latitude: Double,
        longitude: Double
    ): Observable<List<CrimeResponse>>

}