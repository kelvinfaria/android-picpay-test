package com.picpay.desafio.android.data_remote.data_source

import com.picpay.desafio.android.data.data_source.remote.UserRemoteDataSourceInterface
import com.picpay.desafio.android.data_remote.mapper.UserRemoteMapper
import com.picpay.desafio.android.data_remote.service.PicPayService
import com.picpay.desafio.android.data_remote.utils.RequestWrapperInterface
import com.picpay.desafio.android.domain.model.UserList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRemoteDataSource(
    private val picPayService: PicPayService,
    private val requestWrapper: RequestWrapperInterface
) : UserRemoteDataSourceInterface {

    override fun getUserListRemotely(): Flow<UserList> = flow {
        emit(
            UserRemoteMapper.toDomain(
                requestWrapper.wrapper {
                    picPayService.getUserList()
                }
            )
        )
    }
}