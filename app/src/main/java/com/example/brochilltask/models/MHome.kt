package com.example.brochilltask.models

import android.content.Context
import android.widget.Toast
import com.example.brochilltask.manager.ApiManager
import com.example.brochilltask.presenter.PHome
import com.example.brochilltask.presenter.PWelcome
import com.example.brochilltask.util.PreferenceManager
import com.example.example.TweetsResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class MHome(private val context: Context, private val presenter: PHome) {
    fun getTweets() {
        CoroutineScope(Dispatchers.Main).launch {
            val resp = ApiManager().getTweets(PreferenceManager(context).getUserToken()!!)
            presenter?.setTweets(resp as ArrayList<TweetsResponse>)
        }
    }
}