package com.example.brochilltask.presenter

import android.content.Context
import com.example.brochilltask.activities.MainActivity
import com.example.brochilltask.interfaces.ILogin
import com.example.brochilltask.models.MLogin

class PLogin(context: Context, private val view: ILogin.View) : ILogin.Presenter {
    private val model = MLogin(context, this)
    override fun login(email: String, password: String) {
        model.loginUser(email, password)
    }

    override fun register(firstName: String, lastName: String, email: String, password: String) {
        model.registerUser(firstName, lastName, email, password)
    }

    override fun success(isLogin: Boolean) {
        if (!isLogin)
            view.registerSuccess()
        else
            view.loginSuccess()
    }
}