package com.picpay.desafio.android.feature_contact.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.picpay.desafio.android.domain.interactor.GetUserListUseCase
import com.picpay.desafio.android.base_feature.presentation.mapper.UserBindingMapper
import com.picpay.desafio.android.base_feature.presentation.model.UserListBinding
import com.picpay.desafio.android.base_feature.presentation.utils.extensions.*
import com.picpay.desafio.android.base_feature.presentation.utils.isLoading
import com.picpay.desafio.android.domain.interactor.SaveUserListLocallyUseCase
import com.picpay.desafio.android.domain.model.UserList
import org.koin.core.KoinComponent

class ContactListViewModel(application: Application) : AndroidViewModel(application), KoinComponent,
    LifecycleObserver {

    private val getUserListUseCase: GetUserListUseCase by useCase()
    private val saveUserListLocallyUseCase: SaveUserListLocallyUseCase by useCase()

    private val contactListViewState by viewState<UserListBinding>()

    val contactListLiveData = contactListViewState.asLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getContactList() {
        if (contactListViewState.value.isLoading()) return

        contactListViewState.postLoading()
        getUserListUseCase(
            onSuccess = {
                saveContactListLocally(it)
                contactListViewState.postSuccess(UserBindingMapper.fromDomain(it))
            },
            onError = {
                contactListViewState.postError(it)
            }
        )
    }

    private fun saveContactListLocally(userList: UserList) {
        saveUserListLocallyUseCase(
            params = SaveUserListLocallyUseCase.Param(
                userList = userList
            )
        )
    }
}