package com.picpay.desafio.android.base_feature.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.picpay.desafio.android.base_feature.view.utils.ViewStateListener
import org.koin.core.KoinComponent

abstract class BaseFragment : Fragment(), ViewStateListener, KoinComponent {

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

    fun showOptionDialog(
        title: String,
        message: String,
        positveAction: () -> Unit = {},
        negativeAction: () -> Unit = {}
    ) {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton("Sim") { _, _ ->
                positveAction
            }
            setNegativeButton("Não") { _, _ ->
                negativeAction
            }
            show()
        }
    }
}