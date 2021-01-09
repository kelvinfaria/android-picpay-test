package com.picpay.desafio.android.feature_contact.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.base_feature.presentation.model.UserBinding
import com.picpay.desafio.android.base_feature.view.utils.extensions.setGone
import com.picpay.desafio.android.base_feature.view.utils.extensions.setVisible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListItemViewHolder>() {

    var userList = emptyList<UserBinding>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                UserListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder =
        UserListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        )

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    class UserListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: UserBinding) {
            itemView.name.text = user.name
            itemView.username.text = user.username
            itemView.progressBar.setVisible()
            Picasso.get()
                .load(user.img)
                .error(R.drawable.ic_round_account_circle)
                .into(itemView.picture, object : Callback {
                    override fun onSuccess() {
                        itemView.progressBar.setGone()
                    }

                    override fun onError(e: Exception?) {
                        itemView.progressBar.setGone()
                    }
                })
        }
    }
}