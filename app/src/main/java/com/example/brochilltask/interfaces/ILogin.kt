package com.example.brochilltask.interfaces

interface ILogin {
    interface View {
        fun loginSuccess()
        fun registerSuccess()
    }

    interface Presenter {
        fun login(email: String, password: String)
        fun register(firstName: String, lastName: String, email: String, password: String)
        fun success(isLogin: Boolean)
    }
}