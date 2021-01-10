package com.picpay.desafio.android.base_feature.presentation.mapper

import com.picpay.desafio.android.base_feature.presentation.model.UserBinding
import com.picpay.desafio.android.base_feature.presentation.model.UserListBinding
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.model.UserList

object UserBindingMapper {

    fun fromDomain(userBindingList: UserList): UserListBinding {
        return UserListBinding(
            list = parseUserList(userBindingList.list)

        )
    }

    private fun parseUserList(list: List<User>) = list.map {
        parseUser(it)
    }

    private fun parseUser(user: User) = UserBinding(
        img = user.img,
        name = user.name,
        id = user.id,
        username = user.username
    )

}