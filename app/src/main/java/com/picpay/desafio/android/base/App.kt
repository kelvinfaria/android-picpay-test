package com.picpay.desafio.android.base

import android.app.Application
import com.picpay.desafio.android.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    networkModule
                )
            ).androidContext(applicationContext)
        }
    }
}