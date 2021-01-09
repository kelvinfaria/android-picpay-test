package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepositoryInterface {

    fun getUsersRemotely(): Flow<List<User>>
}