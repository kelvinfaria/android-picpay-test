package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.data_source.local.UserLocalDataSourceInterface
import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userRemoteDataSourceInterface: UserRemoteDataSourceInterface,
    private val userLocalDataSourceInterface: UserLocalDataSourceInterface
    ) : UserRepositoryInterface {

    override fun getUserListRemotely(): Flow<List<User>> {
        return userRemoteDataSourceInterface.getUserListRemotely()
    }

    override fun saveUserListLocally(userList: List<User>) {

    }
    override fun getUserListLocally() {
    }
}