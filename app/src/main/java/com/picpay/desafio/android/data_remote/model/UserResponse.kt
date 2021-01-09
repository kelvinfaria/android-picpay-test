package com.picpay.desafio.android.data_remote.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("username")
    val username: String? = null
)