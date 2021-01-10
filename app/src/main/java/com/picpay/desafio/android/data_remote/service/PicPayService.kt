package com.picpay.desafio.android.data_remote.service

import com.picpay.desafio.android.data_remote.model.UserResponse
import retrofit2.Call
import retrofit2.http.*


interface PicPayService {

    @GET(USERS)
    fun getUserList(): Call<List<UserResponse>>
}

const val USERS = "users"
