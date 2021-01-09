package com.picpay.desafio.android.base_feature.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.picpay.desafio.android.R
import com.picpay.desafio.android.base_feature.navigation.SplashNavigationInterface
import com.picpay.desafio.android.base_feature.navigation.utils.navDirections

class SplashFragment : BaseFragment() {

    private val navDirections: SplashNavigationInterface by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun setupView() {
        super.setupView()
        Handler().postDelayed({
            navDirections.navigateToContactList()
        }, 1000)
    }
}