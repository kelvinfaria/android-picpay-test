package com.picpay.desafio.android.domain.interactor

import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import com.picpay.desafio.android.domain.util.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class ClearLocalUserListUseCase(
    scope: CoroutineScope,
    private val userRepositoryInterface: UserRepositoryInterface
) : UseCase<Unit, Unit>(scope) {

    override fun run(params: Unit?): Flow<Unit>  {
        return userRepositoryInterface.clearLocalUserList()
    }
}