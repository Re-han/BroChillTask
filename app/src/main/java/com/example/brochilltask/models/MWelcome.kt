package com.example.brochilltask.models

import android.content.Context
import android.widget.Toast
import com.example.brochilltask.manager.ApiManager
import com.example.brochilltask.presenter.PWelcome
import com.example.brochilltask.util.PreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MWelcome(private val context: Context, private val presenter: PWelcome) {
    fun getWelcomeMessage() {
        CoroutineScope(Dispatchers.Main).launch {
            kotlin.runCatching {
                val resp = ApiManager().getMessage(PreferenceManager(context).getUserToken()!!)
                presenter.getWelcomeMessage(resp.getString("message"))
            }.onFailure {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}