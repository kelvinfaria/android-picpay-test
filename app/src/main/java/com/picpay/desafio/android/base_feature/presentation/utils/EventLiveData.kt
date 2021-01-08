package com.picpay.desafio.android.base_feature.presentation.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class EventLiveData<T> : MutableLiveData<T>() {

    private var hasBeenHandled = false

    private fun getContentIfNotHandled() =
        if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            value
        }

    fun getContent(isSingleEvent: Boolean) = if (isSingleEvent) getContentIfNotHandled() else value

}

fun <T> Flow<T>.asLiveData(): LiveData<ViewState<out T>> = liveData {
    try {
        collect {
            emit(ViewState(ViewState.Status.SUCCESS, it, null))
        }
    } catch (e: Exception) {
        emit(ViewState(ViewState.Status.ERROR, null, e))
    }
}