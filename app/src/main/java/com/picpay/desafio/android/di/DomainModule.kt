package com.picpay.desafio.android.di

import com.picpay.desafio.android.domain.interactor.GetUserListUseCase
import com.picpay.desafio.android.domain.interactor.SaveUserListLocallyUseCase
import com.picpay.desafio.android.domain.util.ThreadContextProvider
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {

    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        GetUserListUseCase(scope = scope, userRepositoryInterface = get())
    }

    factory { (scope: CoroutineScope) ->
        SaveUserListLocallyUseCase(scope = scope, userRepositoryInterface = get())
    }
}