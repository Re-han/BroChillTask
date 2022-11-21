package com.example.brochilltask.interfaces

import com.example.example.TweetsResponse

interface IHome {
    interface View {
        fun setTweetsList(list:ArrayList<TweetsResponse>)
    }

    interface Presenter {
        fun loadTweets()
        fun setTweets(list: java.util.ArrayList<TweetsResponse>?)
    }
}