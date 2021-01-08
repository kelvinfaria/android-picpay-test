package com.picpay.desafio.android.di

import com.picpay.desafio.android.feature_contact.presentation.ContactListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { ContactListViewModel(androidApplication()) }
}