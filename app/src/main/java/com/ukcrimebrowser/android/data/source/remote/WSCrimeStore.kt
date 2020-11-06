package com.ukcrimebrowser.android.data.source.remote

import android.util.Log
import com.ukcrimebrowser.android.data.source.contract.CrimeStore
import com.ukcrimebrowser.android.data.source.remote.response.CrimeResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class WSCrimeStore @Inject constructor(private val ukPolicaDataWebService: UkPolicaDataWebService) :
    CrimeStore {




    override fun getCrimesByAngles(
        date: String,
        latitude: Double,
        longitude: Double
    ): Observable<List<CrimeResponse>> {

        return ukPolicaDataWebService.getCrimesByAngles(
            date = date,
            latitude = latitude,
            longitude = longitude
        )
    }

}