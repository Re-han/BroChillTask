package com.example.brochilltask.models

import android.content.Context
import com.example.brochilltask.manager.ApiManager
import com.example.brochilltask.presenter.PLogin
import com.example.brochilltask.util.PreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MLogin(private val context: Context, private val presenter: PLogin) {
    fun registerUser(fName: String, lName: String, email: String, pass: String) {
        val map = HashMap<String, Any>()
        map["first_name"] = fName
        map["last_name"] = lName
        map["email"] = email
        map["password"] = pass
        CoroutineScope(Dispatchers.Main).launch {
            val resp = ApiManager().registerUser(map)
            PreferenceManager(context).saveUserToken(resp.getString("token"))
            presenter.success(false)
        }
    }

    fun loginUser(email: String, pass: String) {
        val map = HashMap<String, Any>()
        map["email"] = email
        map["password"] = pass
        CoroutineScope(Dispatchers.Main).launch {
            val resp = ApiManager().loginUser(map)
                PreferenceManager(context).saveUserToken(resp.getString("token"))
                presenter.success(true)
        }
    }
}