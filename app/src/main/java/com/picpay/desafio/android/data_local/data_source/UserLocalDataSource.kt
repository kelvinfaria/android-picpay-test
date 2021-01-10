package com.picpay.desafio.android.data_local.data_source

import com.google.gson.Gson
import com.picpay.desafio.android.data.data_source.local.UserLocalDataSourceInterface
import com.picpay.desafio.android.data_local.mapper.UserLocalMapper
import com.picpay.desafio.android.data_local.utils.PreferencesHelper
import com.picpay.desafio.android.domain.model.UserList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserLocalDataSource(
    private val preferencesHelper: PreferencesHelper
) : UserLocalDataSourceInterface {

    override fun saveUserListLocally(userList: UserList): Flow<Unit> = flow {
        emit(
            preferencesHelper.saveString(
                key = USER_LIST,
                data = Gson().toJson(userList)
            )
        )
    }

    override fun getUserListLocally(): Flow<UserList>? {
        val userList = Gson().fromJson(
            preferencesHelper.getString(USER_LIST),
            UserList::class.java
        )

        return when (userList) {
            null -> null
            else -> flow { emit(UserLocalMapper.toDomain(userList)) }
        }
    }

    override fun clearLocalUserList(): Flow<Unit> = flow {
        emit(
            preferencesHelper.deleteKey(USER_LIST)
        )
    }

    companion object {
        const val USER_LIST = "user_list"
    }
}