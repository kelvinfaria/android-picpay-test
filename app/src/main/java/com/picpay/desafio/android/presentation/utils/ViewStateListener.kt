package com.picpay.desafio.android.presentation.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.picpay.desafio.android.presentation.utils.extensions.observeLiveData

interface ViewStateListener {

    fun hideLoading()

    fun onStateLoading()

    fun onStateError(error: Throwable)

    private fun <T> ViewState<T>.handle(
        onLoading: (() -> Unit)? = null,
        onSuccess: ((T) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {

        stateHandler(
            onLoading = {
                onLoading?.invoke() ?: onStateLoading()
            },
            onSuccess = {
                hideLoading()
                onSuccess?.invoke(it)
                onComplete?.invoke()
            },
            onError = { error ->
                hideLoading()
                onError?.invoke(error) ?: onStateError(error)
                onComplete?.invoke()
            }
        )
    }

    fun <T> LiveData<ViewState<T>>.onPostValue(
        lifecycleOwner: LifecycleOwner,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null,
        onLoading: (() -> Unit)? = null,
        onSuccess: ((T) -> Unit)? = null
    ) {
        observeLiveData(lifecycleOwner) {
            it.handle(onLoading, onSuccess, onError, onComplete)
        }

    }

    fun <T> LiveData<ViewState<T>>.onFirstPostValue(
        lifecycleOwner: LifecycleOwner,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null,
        onLoading: (() -> Unit)? = null,
        onSuccess: (T) -> Unit
    ) {
        observeLiveData(lifecycleOwner, true) {
            it.handle(onLoading, onSuccess, onError, onComplete)
        }
    }

}
