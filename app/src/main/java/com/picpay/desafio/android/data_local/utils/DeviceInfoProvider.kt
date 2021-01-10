package com.picpay.desafio.android.data_local.utils

import android.app.Application
import android.os.Build
import android.provider.Settings
import androidx.core.content.pm.PackageInfoCompat
import com.picpay.desafio.android.data.utils.DeviceInfoProviderInterface

class DeviceInfoProvider(private val app: Application) : DeviceInfoProviderInterface {

    override val currentVersion: Int by lazy { Build.VERSION.SDK_INT }

    override val versionCode: Int get() = fetchVersionCode()

    override val androidId by lazy {
        try {
            Settings.Secure.getString(app.contentResolver, Settings.Secure.ANDROID_ID)
        } catch (e: Exception) {
            null
        }
    }

    private fun fetchVersionCode(): Int {
        val packageInfo = app.packageManager.getPackageInfo(app.packageName, 0)
        return PackageInfoCompat.getLongVersionCode(packageInfo).toInt()
    }
}