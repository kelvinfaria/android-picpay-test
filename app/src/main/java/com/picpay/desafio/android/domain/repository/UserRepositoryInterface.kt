package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow

interface UserRepositoryInterface {

    fun getUsersRemotely(): Flow<List<UserDomain>>
}