package com.paprika.thali.utils

import android.text.TextUtils
import android.util.Patterns

/**
 * Created by vicky on 8/12/17.
 */
object ValidationUtils {

    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {

        return password.length == 6
    }
}