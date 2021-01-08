package com.picpay.desafio.android.presentation.mapper

import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.presentation.model.UserBinding

object UserBindingMapper {

    fun fromDomain(userBindingList: List<User>): List<UserBinding> {
        return userBindingList.map {
            UserBinding(
                img = it.img,
                name = it.name,
                id = it.id,
                username = it.username
            )
        }
    }
}