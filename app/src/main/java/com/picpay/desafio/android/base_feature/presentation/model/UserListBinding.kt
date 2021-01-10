package com.picpay.desafio.android.base_feature.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserListBinding(
    val list: List<UserBinding>
) : Parcelable