package com.picpay.desafio.android.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.picpay.desafio.android.domain.interactor.GetUsers
import com.picpay.desafio.android.presentation.mapper.UserBindingMapper
import com.picpay.desafio.android.presentation.model.UserBinding
import com.picpay.desafio.android.presentation.utils.extensions.*
import com.picpay.desafio.android.presentation.utils.isLoading
import org.koin.core.KoinComponent

class ContactListViewModel (application: Application) : AndroidViewModel(application), KoinComponent {

    private val getUsers: GetUsers by useCase()

    private val contactListViewState by viewState<List<UserBinding>>()

    val contactListLiveData = contactListViewState.asLiveData()

    fun getContactList(){
        if (contactListViewState.value.isLoading()) return

        contactListViewState.postLoading()
        getUsers(
            onSuccess = {
                contactListViewState.postSuccess(UserBindingMapper.fromDomain(it))
            },
            onError = {
                contactListViewState.postError(it)
            }
        )
    }
}