package com.picpay.desafio.android.feature_contact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import com.picpay.desafio.android.R
import com.picpay.desafio.android.base_feature.view.BaseFragment
import com.picpay.desafio.android.feature_contact.presentation.ContactListViewModel
import com.picpay.desafio.android.feature_contact.view.adapter.UserListAdapter
import kotlinx.android.synthetic.main.fragment_contact_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactListFragment : BaseFragment() {

    private val userListAdapter by lazy { UserListAdapter() }
    private val viewModel: ContactListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun setupView() {
        super.setupView()
        userListProgressBar.isVisible
    }

    override fun addObservers(owner: LifecycleOwner) {
        lifecycle.addObserver(viewModel)

        viewModel.contactListLiveData.onPostValue(owner,
            onSuccess = {
                userListProgressBar.isGone
                userListAdapter.userList = it
                recyclerView.adapter = userListAdapter
            },
            onError = {
                userListProgressBar.isGone
                showSimpleDialog(
                    title = "Error",
                    message = "Ocorreu um erro inesperado, tente novamente mais tarde"
                )
            }
        )
    }
}