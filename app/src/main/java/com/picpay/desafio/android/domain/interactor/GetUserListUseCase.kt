package com.picpay.desafio.android.domain.interactor

import com.picpay.desafio.android.domain.model.UserList
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import com.picpay.desafio.android.domain.util.UseCase
import kotlinx.coroutines.CoroutineScope

class GetUserListUseCase(
    scope: CoroutineScope,
    private val userRepositoryInterface: UserRepositoryInterface
) : UseCase<UserList, Unit>(scope) {

    override fun run(params: Unit?) = userRepositoryInterface.getUserList()
}