package com.picpay.desafio.android.data.data_source.remote

import com.picpay.desafio.android.domain.UserDomain
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSourceInterface {

    fun getUsers(): Flow<List<UserDomain>>
}
