package com.example.massive.infoAnemia

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoAnemia_Model(
    val imgInfoAnemia: Int,
    val titleInfoAnemia: String,

) : Parcelable
