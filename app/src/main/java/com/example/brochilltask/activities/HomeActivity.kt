package com.example.brochilltask.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brochilltask.R
import com.example.brochilltask.adapter.TweetsAdapter
import com.example.brochilltask.interfaces.IHome
import com.example.brochilltask.presenter.PHome
import com.example.example.TweetsResponse
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), IHome.View {
    var presenter: PHome? = null
    var adapter: TweetsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = PHome(this, this)
        setListeners()
    }

    fun setListeners() {
        newTweet.setOnClickListener {
            startActivity(Intent(this, WriteTweet::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        presenter?.loadTweets()
        adapter?.notifyDataSetChanged()
    }

    override fun setTweetsList(list: ArrayList<TweetsResponse>) {
        tweetsRv.layoutManager = LinearLayoutManager(this)
        adapter = TweetsAdapter(this, list.reversed() as ArrayList<TweetsResponse>)
        tweetsRv.adapter = adapter
    }
}