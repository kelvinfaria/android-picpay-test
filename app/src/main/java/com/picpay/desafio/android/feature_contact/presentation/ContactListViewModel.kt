package com.picpay.desafio.android.feature_contact.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.picpay.desafio.android.domain.interactor.GetUsers
import com.picpay.desafio.android.base_feature.presentation.mapper.UserBindingMapper
import com.picpay.desafio.android.base_feature.presentation.model.UserBinding
import com.picpay.desafio.android.base_feature.presentation.utils.extensions.*
import com.picpay.desafio.android.base_feature.presentation.utils.isLoading
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