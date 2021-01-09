package com.picpay.desafio.android.network

import android.content.res.Resources
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data_remote.utils.RequestWrapperInterface
import retrofit2.Call
import retrofit2.Response

class RequestWrapper(private val resources: Resources): RequestWrapperInterface {

    override suspend fun <B> wrapper(request: suspend () -> Call<B>): B {
        try {
            val response: Response<B> = request().execute()
            if (response.isSuccessful)
                return response.body()!!
            throw Exception("Error (${response.code()})\n${response.message()}")

        }catch (e: Exception){
            throw Exception(resources.getString(R.string.generic_error, e.message))
        }
    }
}