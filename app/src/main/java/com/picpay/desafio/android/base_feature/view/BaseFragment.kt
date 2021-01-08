package com.picpay.desafio.android.base_feature.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.picpay.desafio.android.base_feature.view.utils.ViewStateListener
import org.koin.core.KoinComponent

abstract class BaseFragment : Fragment(), ViewStateListener, KoinComponent {

    private val loadingDialogFragment = LoadingFragment()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addObservers(viewLifecycleOwner)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    open fun setupView() = Unit

    open fun addObservers(owner: LifecycleOwner) = Unit

    override fun hideLoading() {
        loadingDialogFragment.dismissAllowingStateLoss()
    }

    override fun onStateLoading() {
        hideLoading()
        childFragmentManager.let { loadingDialogFragment.show(this) }
    }

    override fun onStateError(error: Throwable) {
        hideLoading()
        error.message?.let {
            showSimpleDialog(
                title = "Error",
                message = "Ocorreu um erro inesperado, tente novamente mais tarde"
            )
        }
    }

    fun showSimpleDialog(
        title: String,
        message: String,
        action: () -> Unit = {}
    ) {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton("OK") { _, _ ->
                action
            }
            show()
        }
    }
}