package com.picpay.desafio.android

import com.picpay.desafio.android.data_remote.model.UserResponse
import com.picpay.desafio.android.data_remote.service.PicPayService

class ExampleService(
    private val service: PicPayService
) {

    fun example(): List<UserResponse> {
        val users = service.getUserList().execute()

        return users.body() ?: emptyList()
    }
}