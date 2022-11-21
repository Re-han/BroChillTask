package com.example.brochilltask.presenter

import android.content.Context
import com.example.brochilltask.activities.MainActivity
import com.example.brochilltask.interfaces.IHome
import com.example.brochilltask.interfaces.ILogin
import com.example.brochilltask.interfaces.IWelcome
import com.example.brochilltask.models.MHome
import com.example.brochilltask.models.MLogin
import com.example.brochilltask.models.MWelcome
import com.example.example.TweetsResponse
import java.util.ArrayList

class PHome(context: Context, private val view: IHome.View) : IHome.Presenter {
    private val model = MHome(context, this)

    init {
        loadTweets()
    }

    override fun loadTweets() {
        model.getTweets()
    }

    override fun setTweets(list: ArrayList<TweetsResponse>?) {
        if (list != null) {
            view.setTweetsList(list)
        }
    }

}