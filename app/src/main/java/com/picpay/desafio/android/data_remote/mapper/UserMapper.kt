package com.picpay.desafio.android.data_remote.mapper

import com.picpay.desafio.android.data_remote.model.UserResponse
import com.picpay.desafio.android.domain.UserDomain

object UserMapper {

    fun toDomain(data: List<UserResponse>): List<UserDomain> {
        return data.map {
            UserDomain(
                img = it.img ?: "",
                name = it.name ?: "",
                id = it.id ?: 0,
                username = it.username ?: ""
            )
        }
    }
}