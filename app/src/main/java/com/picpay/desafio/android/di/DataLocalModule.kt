package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.data_source.local.UserLocalDataSourceInterface
import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.data.utils.DeviceInfoProviderInterface
import com.picpay.desafio.android.data_local.data_source.UserLocalDataSource
import com.picpay.desafio.android.data_local.utils.DeviceInfoProvider
import com.picpay.desafio.android.data_local.utils.PreferencesHelper
import com.picpay.desafio.android.data_remote.data_source.UserRemoteDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataLocalModule = module {

    single<DeviceInfoProviderInterface> { DeviceInfoProvider(androidApplication()) }

    single { PreferencesHelper(androidApplication(), get()) }

    single<UserLocalDataSourceInterface> { UserLocalDataSource(get() ) }
}
