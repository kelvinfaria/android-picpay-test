package com.picpay.desafio.android.data_remote.utils

import retrofit2.Call

interface RequestWrapperInterface {

    suspend fun <B> wrapper(
        request: suspend ()-> Call<B>
    ): B
}