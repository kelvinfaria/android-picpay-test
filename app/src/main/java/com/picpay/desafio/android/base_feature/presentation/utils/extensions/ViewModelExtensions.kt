package com.picpay.desafio.android.base_feature.presentation.utils.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.util.UseCase
import com.picpay.desafio.android.base_feature.presentation.utils.ViewState
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

inline fun <V, reified U> V.useCase() where U : UseCase<*, *>, V : ViewModel, V : KoinComponent =
    inject<U> {
        parametersOf(viewModelScope)
    }

fun <T> viewState() = lazy {
    MutableLiveData<ViewState<T>>()
}
