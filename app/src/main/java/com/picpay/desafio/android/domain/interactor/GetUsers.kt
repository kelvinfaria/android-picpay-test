package com.picpay.desafio.android.domain.interactor

import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import com.picpay.desafio.android.domain.util.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetUsers(
    scope: CoroutineScope,
    private val userRepositoryInterface: UserRepositoryInterface
) : UseCase<List<User>, Unit>(scope) {

    override fun run(params: Unit?): Flow<List<User>> {
        return userRepositoryInterface.getUsersRemotely()
    }
}