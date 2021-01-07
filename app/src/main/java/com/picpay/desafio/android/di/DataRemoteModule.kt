package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.data_remote.data_source.UserRemoteDataSource
import org.koin.dsl.module

val dataRemoteModule = module {

    single<UserRemoteDataSourceInterface> { UserRemoteDataSource(get(), get()) }
}