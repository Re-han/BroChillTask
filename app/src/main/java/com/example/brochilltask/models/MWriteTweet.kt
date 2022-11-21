package com.example.brochilltask.models

import android.content.Context
import com.example.brochilltask.manager.ApiManager
import com.example.brochilltask.presenter.PWelcome
import com.example.brochilltask.presenter.PWriteTweet
import com.example.brochilltask.util.PreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MWriteTweet(private val context: Context, private val presenter: PWriteTweet) {
    fun writeTweet(tweet: String) {
        val map = HashMap<String, Any>()
        map["tweet"] = tweet
        CoroutineScope(Dispatchers.Main).launch {
            val resp = ApiManager().writeTweet(PreferenceManager(context).getUserToken()!!, map)
            presenter?.closeTweetScreen()
        }
    }
}