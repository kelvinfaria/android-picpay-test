package com.picpay.desafio.android.data_local.utils

import android.util.Base64

object CryptHelper {
    fun decryptData(it: String): String? {
        return try {
            String(Base64.decode(it, Base64.NO_WRAP))
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    fun encryptData(data: String) = try {
        Base64.encodeToString(data.toByteArray(), Base64.NO_WRAP)
    } catch (e: AssertionError) {
        null
    }

}