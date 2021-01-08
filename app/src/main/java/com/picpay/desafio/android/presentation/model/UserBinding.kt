package com.picpay.desafio.android.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserBinding (
    val img: String,
    val name: String,
    val id: Int,
    val username: String
): Parcelable