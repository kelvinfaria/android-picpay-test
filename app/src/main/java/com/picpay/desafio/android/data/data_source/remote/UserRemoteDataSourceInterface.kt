package com.picpay.desafio.android.data.data_source.remote

import com.picpay.desafio.android.domain.model.UserList
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSourceInterface {

    fun getUserListRemotely(): Flow<UserList>
}
