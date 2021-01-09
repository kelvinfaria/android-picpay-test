package com.picpay.desafio.android.feature_contact.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.base_feature.presentation.model.UserBinding
import com.picpay.desafio.android.data_remote.model.UserResponse

class UserListDiffCallback(
    private val oldList: List<UserBinding>,
    private val newList: List<UserBinding>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].username == newList[newItemPosition].username
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}