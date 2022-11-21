package com.example.brochilltask.presenter

import android.content.Context
import com.example.brochilltask.activities.MainActivity
import com.example.brochilltask.interfaces.ILogin
import com.example.brochilltask.interfaces.IWelcome
import com.example.brochilltask.models.MLogin
import com.example.brochilltask.models.MWelcome

class PWelcome(context: Context, private val view: IWelcome.View) : IWelcome.Presenter {
    private val model = MWelcome(context, this)

    init {
        model.getWelcomeMessage()
    }

    override fun getWelcomeMessage(message: String) {
        view?.setMessage(message)
    }

}