package com.example.brochilltask.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.brochilltask.R
import com.example.brochilltask.interfaces.IWriteTweet
import com.example.brochilltask.presenter.PWriteTweet
import kotlinx.android.synthetic.main.activity_write_tweet.*

class WriteTweet : AppCompatActivity(), IWriteTweet.View {

    var presenter: PWriteTweet? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_tweet)
        presenter = PWriteTweet(this, this)
        setListeners()
    }

    private fun setListeners() {
        postTweetButton.setOnClickListener { postTweet() }
    }

    private fun postTweet() {
        if (tweet.text.isEmpty()) {
            Toast.makeText(this, "Field can't be empty!", Toast.LENGTH_SHORT).show()
        } else
            presenter?.writeTweet(tweet.text.toString())
    }

    override fun finishThisActivity() {
        finish()
    }
}