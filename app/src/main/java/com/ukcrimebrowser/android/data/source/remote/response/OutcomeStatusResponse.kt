package com.ukcrimebrowser.android.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.ukcrimebrowser.android.data.source.local.OutcomeStatusEntity


fun OutcomeStatusResponse.toOutcomeStatusEntity(): OutcomeStatusEntity {
    return OutcomeStatusEntity(
        category = this.category,
        date = this.date
    )
}

data class OutcomeStatusResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("date")
    val date: String
)