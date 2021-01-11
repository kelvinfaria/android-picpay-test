package com.picpay.desafio.android.feature_contact.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.picpay.desafio.android.domain.interactor.GetUserListUseCase
import com.picpay.desafio.android.base_feature.presentation.mapper.UserBindingMapper
import com.picpay.desafio.android.base_feature.presentation.model.UserListBinding
import com.picpay.desafio.android.base_feature.presentation.utils.extensions.*
import com.picpay.desafio.android.base_feature.presentation.utils.isLoading
import com.picpay.desafio.android.domain.interactor.ClearLocalUserListUseCase
import com.picpay.desafio.android.domain.interactor.SaveUserListLocallyUseCase
import com.picpay.desafio.android.domain.model.UserList
import org.koin.core.KoinComponent

class ContactListViewModel(application: Application) : AndroidViewModel(application),
    KoinComponent {

    private val getUserListUseCase: GetUserListUseCase by useCase()
    private val saveUserListLocallyUseCase: SaveUserListLocallyUseCase by useCase()
    private val clearLocalUserListUseCase: ClearLocalUserListUseCase by useCase()

    private val contactListViewState by viewState<UserListBinding>()
    private val saveContactListViewState by viewState<Unit>()
    private val clearContactListViewState by viewState<Unit>()

    val contactListLiveData = contactListViewState.asLiveData()
    val saveContactListLiveData = saveContactListViewState.asLiveData()
    val clearContactListLiveData = clearContactListViewState.asLiveData()

    var firstLaunch = true

    fun getContactList(isRefreshing: Boolean = false) {
        if (contactListViewState.value.isLoading()) return

        contactListViewState.postLoading()
        getUserListUseCase(
            params = GetUserListUseCase.Param(
                isRefreshing = isRefreshing
            ),
            onSuccess = {
                when (it.isLocal) {
                    true -> {
                        saveContactListLocally(it)
                    }
                    false -> {
                        saveContactListViewState.postSuccess(Unit)
                    }
                }
                firstLaunch = false
                contactListViewState.postSuccess(UserBindingMapper.fromDomain(it))
                clearContactListViewState.postNeutral()
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
            ),
            onSuccess = {
                saveContactListViewState.postSuccess(Unit)
            }
        )
    }

    fun clearLocalUserList() {
        clearLocalUserListUseCase(
            onSuccess = {
                clearContactListViewState.postSuccess(Unit)
                contactListViewState.postNeutral()
                saveContactListViewState.postNeutral()
            }
        )
    }
}