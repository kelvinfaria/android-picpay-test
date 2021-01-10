package com.picpay.desafio.android.data_local.mapper

import com.picpay.desafio.android.domain.model.UserList

object UserLocalMapper {

    fun toDomain(userList: UserList): UserList {
        return UserList(
            list = userList.list,
            isLocal = true
        )
    }
}