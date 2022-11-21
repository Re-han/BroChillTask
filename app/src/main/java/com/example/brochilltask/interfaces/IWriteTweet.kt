package com.example.brochilltask.interfaces

interface IWriteTweet {
    interface View {
        fun finishThisActivity()

    }

    interface Presenter {
        fun writeTweet(tweet:String)
        fun closeTweetScreen()
    }
}