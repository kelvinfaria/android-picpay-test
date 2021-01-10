package com.picpay.desafio.android.data_remote.mapper

import com.picpay.desafio.android.data_remote.model.UserResponse
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.model.UserList

object UserRemoteMapper {

    fun toDomain(userList: List<UserResponse>): UserList {
        return UserList(
            list = parseUserList(userList)
        )
    }

    private fun parseUserList(userList: List<UserResponse>) = userList.map {
        parseUser(it)
    }

    private fun parseUser(user: UserResponse) = User(
        img = user.img ?: "",
        name = user.name ?: "",
        id = user.id ?: 0,
        username = user.username ?: ""
    )
}