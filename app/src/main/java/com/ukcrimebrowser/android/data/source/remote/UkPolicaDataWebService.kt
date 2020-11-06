package com.ukcrimebrowser.android.data.source.remote

import com.ukcrimebrowser.android.data.source.remote.response.CrimeResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UkPolicaDataWebService {

    companion object {

        /**
         * @return the base url of [UkPolicaDataWebService]
         */

        // Usually differs by environment but for simplicity just the return the production url
        fun baseURL(): String = "https://data.police.uk/api/"
    }

    @GET(Paths.CRIMES_AT_LOCATION_PATH)
    fun getCrimesByLocationId(
        @Query("date") date: String,
        @Query("location_id") locationId: Long
    ): Single<List<CrimeResponse>>


    @GET(Paths.CRIMES_AT_LOCATION_PATH)
    fun getCrimesByAngles(
        @Query("date") date: String,
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double
    ): Observable<List<CrimeResponse>>
}