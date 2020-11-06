package com.ukcrimebrowser.android.data.source.local

/**
 * Simulates Entity from Data Persistence
 */
data class CrimeEntity(
    val id: Int,
    val category: String,
    val context: String?,
    val locationType: String,
    val locationSubtype: String,
    val month: String,
    val persistentId: String,
    val location: LocationEntity,
    val outcomeStatus: OutcomeStatusEntity?
)

data class LocationEntity(
    val latitude: String,
    val longitude: String,
    val streetEntity: StreetEntity
)

data class StreetEntity(
    val id: Int,
    val name: String
)

data class OutcomeStatusEntity(
    val category: String,
    val date: String
)


