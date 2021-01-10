package com.picpay.desafio.android.data.utils

interface DeviceInfoProviderInterface {
    val currentVersion: Int
    val androidId: String?
    val versionCode: Int
}