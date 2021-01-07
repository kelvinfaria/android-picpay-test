package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.domain.model.UserDomain
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userRemoteDataSourceInterface: UserRemoteDataSourceInterface
    ) : UserRepositoryInterface {

    override fun getUsersRemotely(): Flow<List<UserDomain>> {
        return userRemoteDataSourceInterface.getUsers()
    }

}