package com.samsdk.mvpexample.presenter

import com.samsdk.mvpexample.model.User
import com.samsdk.mvpexample.view.ILoginView

class LoginPresenter(var iLoginView: ILoginView) : ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        if (user.isValid)
            iLoginView.onLoginResult("Success")
        else
            iLoginView.onLoginResult("Error")
    }
}