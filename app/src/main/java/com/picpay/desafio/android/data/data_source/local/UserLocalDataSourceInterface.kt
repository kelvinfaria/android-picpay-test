package com.picpay.desafio.android.data.data_source.local

import com.picpay.desafio.android.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSourceInterface {

    fun saveUserListLocally(userList: List<User>)
    fun getUserListLocally()
}
