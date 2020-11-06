package com.ukcrimebrowser.android.presentation.crime

import android.os.Parcelable
import com.ukcrimebrowser.android.data.source.local.CrimeEntity
import kotlinx.android.parcel.Parcelize

fun CrimeEntity.toCrimeDetail(): CrimeDetail {
    return CrimeDetail(
        id = this.id,
        category = this.category,
        month = this.month,
        context = this.context,
        latitude = this.location.latitude,
        longitude = this.location.longitude,
        streetName = this.location.streetEntity.name,
        outcomeStatus = this.outcomeStatus?.category,
        outcomeDate = this.outcomeStatus?.date
    )
}

@Parcelize
class CrimeDetail(
    val id: Int,
    val category: String,
    val month: String,
    val latitude: String,
    val longitude: String,
    val streetName: String,
    val context: String?,
    val outcomeStatus: String?,
    val outcomeDate: String?
): Parcelable