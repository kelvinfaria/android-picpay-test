package com.picpay.desafio.android.navigation.base_feature

import androidx.fragment.app.Fragment
import com.picpay.desafio.android.base_feature.navigation.SplashNavigationInterface
import com.picpay.desafio.android.base_feature.view.SplashFragmentDirections
import com.picpay.desafio.android.navigation.utils.navigate

class SplashNavigation(private val fragment: Fragment) : SplashNavigationInterface {

    override fun navigateToContactList() =
        fragment.navigate(SplashFragmentDirections.actionSplashFragmentToContactListFragment())
}