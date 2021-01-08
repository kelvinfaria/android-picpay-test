package com.picpay.desafio.android.domain.interactor

import com.picpay.desafio.android.domain.model.UserDomain
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import com.picpay.desafio.android.domain.util.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetUsers(
    scope: CoroutineScope,
    private val userRepositoryInterface: UserRepositoryInterface
) : UseCase<List<UserDomain>, Unit>(scope) {

    override fun run(params: Unit?): Flow<List<UserDomain>> {
        return userRepositoryInterface.getUsersRemotely()
    }
}