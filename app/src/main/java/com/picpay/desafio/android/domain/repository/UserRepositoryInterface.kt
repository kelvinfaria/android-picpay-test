package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.domain.model.UserList
import kotlinx.coroutines.flow.Flow

interface UserRepositoryInterface {

    fun getUserList(): Flow<UserList>
    fun saveUserListLocally(userList: UserList): Flow<Unit>
}