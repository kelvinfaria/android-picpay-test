package com.picpay.desafio.android.base_feature.view.utils.extensions

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.picpay.desafio.android.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

fun View.setGone() {
    visibility = View.GONE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun ImageView.setImageWithLoading(progressBar: ProgressBar, load: String, error: Int) {
    progressBar.setVisible()

    Picasso.get()
        .load(load)
        .error(error)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.setGone()
            }

            override fun onError(e: Exception?) {
                progressBar.setGone()
            }
        })
}