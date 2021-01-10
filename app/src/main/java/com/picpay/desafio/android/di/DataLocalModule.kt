package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.data_source.local.UserLocalDataSourceInterface
import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.data_local.data_source.UserLocalDataSource
import com.picpay.desafio.android.data_remote.data_source.UserRemoteDataSource
import org.koin.dsl.module

val dataLocalModule = module {

    single<UserLocalDataSourceInterface> { UserLocalDataSource() }
}
