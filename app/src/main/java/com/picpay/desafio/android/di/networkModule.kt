package com.picpay.desafio.android.di

import com.picpay.desafio.android.data_remote.service.PicPayService
import com.picpay.desafio.android.network.WebServiceFactory
import com.picpay.desafio.android.network.WebServiceFactory.provideOkHttpClient
import org.koin.dsl.module

val networkModule = module {

    single { provideOkHttpClient() }

    single {
        WebServiceFactory.createWebService(
            get(),
            url = ""
        ) as PicPayService
    }
}