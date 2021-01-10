package com.picpay.desafio.android.domain.interactor

import com.picpay.desafio.android.domain.model.UserList
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import com.picpay.desafio.android.domain.util.UseCase
import com.picpay.desafio.android.domain.util.exceptions.MissingParamsException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SaveUserListLocallyUseCase(
    scope: CoroutineScope,
    private val userRepositoryInterface: UserRepositoryInterface
) : UseCase<Unit, SaveUserListLocallyUseCase.Param>(scope) {

    override fun run(params: Param?): Flow<Unit> = when (params) {
        null -> throw MissingParamsException()
        else -> userRepositoryInterface.saveUserListLocally(params.userList)
    }

    data class Param(
        val userList: UserList
    )
}