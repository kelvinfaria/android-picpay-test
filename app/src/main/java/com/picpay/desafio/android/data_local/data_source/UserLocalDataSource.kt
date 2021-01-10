package com.picpay.desafio.android.data_local.data_source

import com.google.gson.Gson
import com.picpay.desafio.android.data.data_source.local.UserLocalDataSourceInterface
import com.picpay.desafio.android.data_local.utils.PreferencesHelper
import com.picpay.desafio.android.domain.model.UserList
import kotlinx.coroutines.flow.flow

class UserLocalDataSource(
    private val preferencesHelper: PreferencesHelper
) : UserLocalDataSourceInterface {

    override fun saveUserListLocally(userList: UserList) {
        preferencesHelper.saveString(
            key = USER_LIST,
            data = Gson().toJson(userList)
        )
    }

    override fun getUserListLocally() = flow {
        emit(
            Gson().fromJson(
                preferencesHelper.getString(USER_LIST),
                UserList::class.java
            )
        )
    }

    companion object {
        const val USER_LIST = "user_list"
    }
}