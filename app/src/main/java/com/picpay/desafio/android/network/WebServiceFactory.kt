package com.picpay.desafio.android.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object WebServiceFactory {

    inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
        val gson: Gson by lazy { GsonBuilder().create() }

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create()
    }

    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()
}