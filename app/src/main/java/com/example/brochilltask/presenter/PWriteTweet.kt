package com.example.brochilltask.presenter

import android.content.Context
import com.example.brochilltask.activities.MainActivity
import com.example.brochilltask.interfaces.IHome
import com.example.brochilltask.interfaces.ILogin
import com.example.brochilltask.interfaces.IWelcome
import com.example.brochilltask.interfaces.IWriteTweet
import com.example.brochilltask.models.MHome
import com.example.brochilltask.models.MLogin
import com.example.brochilltask.models.MWelcome
import com.example.brochilltask.models.MWriteTweet
import com.example.example.TweetsResponse
import java.util.ArrayList

class PWriteTweet(context: Context, private val view: IWriteTweet.View) : IWriteTweet.Presenter {
    private val model = MWriteTweet(context, this)
    override fun writeTweet(tweet: String) {
        model.writeTweet(tweet)
    }

    override fun closeTweetScreen() {
        view?.finishThisActivity()
    }

}