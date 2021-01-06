package com.picpay.desafio.android.di

import com.picpay.desafio.android.BuildConfig.*
import com.picpay.desafio.android.data_remote.service.PicPayService
import com.picpay.desafio.android.data_remote.utils.RequestWrapperInterface
import com.picpay.desafio.android.network.BASE_URL
import com.picpay.desafio.android.network.RequestWrapper
import com.picpay.desafio.android.network.WebServiceFactory
import com.picpay.desafio.android.network.WebServiceFactory.provideOkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {

    single {
        provideOkHttpClient(
            DEBUG && BUILD_TYPE == "debug"
        )
    }

    single {
        WebServiceFactory.createWebService(
            get(),
            url = BASE_URL
        ) as PicPayService
    }

    single<RequestWrapperInterface> { RequestWrapper(androidApplication().resources) }

}