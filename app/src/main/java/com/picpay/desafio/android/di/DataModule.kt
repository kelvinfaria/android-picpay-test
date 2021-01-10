package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.repository.UserRepository
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import org.koin.dsl.module

val dataModule = module {

    single<UserRepositoryInterface> { UserRepository(get(), get()) }
}