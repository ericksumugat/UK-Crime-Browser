package com.ukcrimebrowser.android.data.source.remote.response
import com.google.gson.annotations.SerializedName
import com.ukcrimebrowser.android.data.source.local.StreetEntity

fun StreetResponse.toStreetEntity(): StreetEntity {
    return StreetEntity(
        id = this.id,
        name = this.name
    )
}

data class StreetResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)