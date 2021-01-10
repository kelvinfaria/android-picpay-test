package com.picpay.desafio.android.domain.interactor

import com.picpay.desafio.android.domain.model.UserList
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import com.picpay.desafio.android.domain.util.UseCase
import com.picpay.desafio.android.domain.util.exceptions.MissingParamsException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetUserListUseCase(
    scope: CoroutineScope,
    private val userRepositoryInterface: UserRepositoryInterface
) : UseCase<UserList, GetUserListUseCase.Param>(scope) {

    override fun run(params: Param?): Flow<UserList> = when (params) {
        null -> throw MissingParamsException()
        else -> userRepositoryInterface.getUserList(params.isRefreshing)
    }

    data class Param(
        val isRefreshing: Boolean
    )
}