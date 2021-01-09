package com.picpay.desafio.android.di

import androidx.fragment.app.Fragment
import com.picpay.desafio.android.base_feature.navigation.SplashNavigationInterface
import com.picpay.desafio.android.navigation.base_feature.SplashNavigation
import org.koin.dsl.module

val navigationModule = module {

    factory<SplashNavigationInterface> { (fragment: Fragment) ->
        SplashNavigation(fragment)
    }
}