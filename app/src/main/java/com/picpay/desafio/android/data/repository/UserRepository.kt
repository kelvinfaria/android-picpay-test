package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.data_source.local.UserLocalDataSourceInterface
import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.domain.model.UserList
import com.picpay.desafio.android.domain.repository.UserRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(
    private val userRemoteDataSourceInterface: UserRemoteDataSourceInterface,
    private val userLocalDataSourceInterface: UserLocalDataSourceInterface
) : UserRepositoryInterface {

    override fun getUserList(): Flow<UserList> {
        return userLocalDataSourceInterface.getUserListLocally() ?: userRemoteDataSourceInterface.getUserListRemotely()
    }

    override fun saveUserListLocally(userList: UserList) = flow {
        emit(userLocalDataSourceInterface.saveUserListLocally(userList))
    }
}