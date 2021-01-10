package com.picpay.desafio.android.data.data_source.local

import com.picpay.desafio.android.domain.model.UserList
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSourceInterface {

    fun saveUserListLocally(userList: UserList)
    fun getUserListLocally(): Flow<UserList>?
}
