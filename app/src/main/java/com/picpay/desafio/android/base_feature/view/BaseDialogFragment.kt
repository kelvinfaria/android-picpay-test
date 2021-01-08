package com.picpay.desafio.android.base_feature.view

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

open class BaseDialogFragment: DialogFragment(), LifecycleObserver {

    private var isLoading = false
    private var lifecycleOwner: LifecycleOwner? = null

    fun show(fragmentContainer: BaseFragment){
        this.lifecycleOwner = fragmentContainer.apply {
            lifecycle.addObserver(this@BaseDialogFragment)
            show(fragmentContainer.childFragmentManager, this@BaseDialogFragment::class.java.simpleName)
        }
    }

    fun show(container: FragmentActivity) {
        this.lifecycleOwner = container.apply {
            lifecycle.addObserver(this@BaseDialogFragment)
            show(container.supportFragmentManager, this@BaseDialogFragment::class.java.simpleName)
        }
    }
}