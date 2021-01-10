package com.picpay.desafio.android.data_local.utils

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.picpay.desafio.android.data.utils.DeviceInfoProviderInterface
import com.picpay.desafio.android.data_local.utils.CryptHelper.decryptData
import com.picpay.desafio.android.data_local.utils.CryptHelper.encryptData

class PreferencesHelper(context: Context, buildProvider: DeviceInfoProviderInterface) {

    private val sharedPreferences = when (buildProvider.currentVersion >= Build.VERSION_CODES.M) {
        true -> createEncryptedSharedPreferences(context)
        false -> context.getSharedPreferences(SHARED_PREFERENCES_APP_NAME, Context.MODE_PRIVATE)
    }

    private fun createEncryptedSharedPreferences(context: Context): SharedPreferences {
        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

        return EncryptedSharedPreferences.create(
                context,
                SHARED_PREFERENCES_APP_NAME,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun saveString(key: String, data: String?) = sharedPreferences.edit().run {
        putString(encryptData(key), data?.let { encryptData(it) })
        apply()
    }

    fun getString(key: String) = sharedPreferences.run {
        getString(encryptData(key), null)?.let {
            decryptData(it)
        }
    }

    fun saveFloat(key: String, value: Float) = sharedPreferences.edit {
        putFloat(encryptData(key), value)
    }

    fun getFloat(key: String) = sharedPreferences.getFloat(encryptData(key), 0f)

    fun deleteKey(key: String) = sharedPreferences.edit {
        remove(encryptData(key))
    }

    fun saveBoolean(key: String, value: Boolean) = sharedPreferences.edit {
        putBoolean(encryptData(key), value)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false) =
            sharedPreferences.getBoolean(encryptData(key), defaultValue)

    companion object {
        private const val SHARED_PREFERENCES_APP_NAME =
                "com.picpay.desafio.android.data_local.data_source.PreferencesHelper"
    }
}