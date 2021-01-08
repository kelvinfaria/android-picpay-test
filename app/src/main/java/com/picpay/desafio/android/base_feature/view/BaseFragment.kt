package com.picpay.desafio.android.base_feature.view

import androidx.fragment.app.Fragment
import com.picpay.desafio.android.base_feature.view.utils.ViewStateListener
import org.koin.core.KoinComponent

abstract class BaseFragment : Fragment(), ViewStateListener, KoinComponent {
}