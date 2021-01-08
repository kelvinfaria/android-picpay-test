package com.picpay.desafio.android.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.picpay.desafio.android.domain.interactor.GetUsers
import com.picpay.desafio.android.presentation.utils.extensions.useCase
import org.koin.core.KoinComponent

class ContactListViewModel (application: Application) : AndroidViewModel(application), KoinComponent {

    private val getUsers: GetUsers by useCase()
}