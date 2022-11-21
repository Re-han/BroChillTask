package com.example.brochilltask.interfaces

interface IWelcome {
    interface View {
        fun setMessage(message: String)

    }

    interface Presenter {
        fun getWelcomeMessage(message:String)
    }
}