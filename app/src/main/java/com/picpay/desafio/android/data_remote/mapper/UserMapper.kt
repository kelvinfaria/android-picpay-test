package com.picpay.desafio.android.data_remote.mapper

import com.picpay.desafio.android.data_remote.model.UserResponse
import com.picpay.desafio.android.domain.model.User

object UserMapper {

    fun toDomain(userList: List<UserResponse>): List<User> {
        return userList.map {
            User(
                img = it.img ?: "",
                name = it.name ?: "",
                id = it.id ?: 0,
                username = it.username ?: ""
            )
        }
    }
}