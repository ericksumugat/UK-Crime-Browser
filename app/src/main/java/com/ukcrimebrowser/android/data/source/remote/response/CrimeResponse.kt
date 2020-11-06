package com.ukcrimebrowser.android.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.ukcrimebrowser.android.data.source.local.CrimeEntity

fun CrimeResponse.toCrimeEntity(): CrimeEntity {
    return CrimeEntity(
        id = this.id,
        category = this.category ?: "",
        context = this.context,
        locationType = this.locationType ?: "",
        locationSubtype = this.locationSubtype ?: "",
        month = this.month ?: "",
        persistentId = this.persistentId ?: "",
        location = this.locationResponse.toLocationEntity(),
        outcomeStatus = this.outcomeStatusResponse?.toOutcomeStatusEntity() ?: null
    )
}


data class CrimeResponse(
    @SerializedName("category")
    val category: String?,
    @SerializedName("context")
    val context: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val locationResponse: LocationResponse,
    @SerializedName("location_subtype")
    val locationSubtype: String?,
    @SerializedName("location_type")
    val locationType: String?,
    @SerializedName("month")
    val month: String?,
    @SerializedName("outcome_status")
    val outcomeStatusResponse: OutcomeStatusResponse?,
    @SerializedName("persistent_id")
    val persistentId: String?
)