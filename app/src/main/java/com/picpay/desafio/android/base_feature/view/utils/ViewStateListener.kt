package com.picpay.desafio.android.base_feature.view.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.picpay.desafio.android.base_feature.presentation.utils.ViewState
import com.picpay.desafio.android.base_feature.presentation.utils.extensions.observeLiveData

interface ViewStateListener {

//    fun hideLoading()

//    fun onStateLoading()

//    fun onStateError(error: Throwable)

    private fun <T> ViewState<T>.handle(
        onLoading: (() -> Unit)? = null,
        onSuccess: ((T) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {

        stateHandler(
            onLoading = {
                onLoading?.invoke()
            },
            onSuccess = {
//                hideLoading()
                onSuccess?.invoke(it)
                onComplete?.invoke()
            },
            onError = { error ->
//                hideLoading()
                onError?.invoke(error)
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
