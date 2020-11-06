package com.ukcrimebrowser.android.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.ukcrimebrowser.android.data.source.local.LocationEntity


fun LocationResponse.toLocationEntity(): LocationEntity {
    return LocationEntity(
        latitude = this.latitude,
        longitude = this.longitude,
        streetEntity = this.street.toStreetEntity()
    )
}


data class LocationResponse(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("street")
    val street: StreetResponse
)