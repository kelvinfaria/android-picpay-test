package com.picpay.desafio.android.feature_contact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.picpay.desafio.android.R
import com.picpay.desafio.android.base_feature.view.BaseFragment
import com.picpay.desafio.android.base_feature.view.utils.extensions.setGone
import com.picpay.desafio.android.base_feature.view.utils.extensions.setVisible
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
        viewModel.getContactList()

        swipeContainer.setOnRefreshListener {
            viewModel.getContactList(isRefreshing = true)
        }
    }

    override fun addObservers(owner: LifecycleOwner) {
        viewModel.contactListLiveData.onPostValue(owner,
            onLoading = {
                contactListProgressBar.setVisible()
                swipeContainer.isRefreshing = false
            },
            onSuccess = {
                contactListProgressBar.setGone()
                userListAdapter.userList = it.list
                recyclerView.adapter = userListAdapter
            },
            onError = {
                contactListProgressBar.setGone()
                showOptionDialog(
                    title = "Error",
                    message = "Deseja realizar uma nova requisição?",
                    positveAction = { viewModel.getContactList(isRefreshing = true) }
                )
            }
        )
    }
}