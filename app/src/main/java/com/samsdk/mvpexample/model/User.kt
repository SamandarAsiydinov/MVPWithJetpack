package com.samsdk.mvpexample.model

import android.text.TextUtils
import android.util.Patterns

data class User(override val email: String, override val password: String) : IUser {
    override val isValid: Boolean
        get() = (!TextUtils.isEmpty(email)
                && Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && password.length > 6)
}