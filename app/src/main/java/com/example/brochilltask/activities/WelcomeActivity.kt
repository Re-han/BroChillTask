package com.example.brochilltask.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brochilltask.R
import com.example.brochilltask.interfaces.IWelcome
import com.example.brochilltask.presenter.PWelcome
import com.example.brochilltask.util.PreferenceManager
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), IWelcome.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        PWelcome(this, this)
        setListeners()
    }

    private fun setListeners() {
        startButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java).apply {
                this.flags =
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
        logout.setOnClickListener {
            PreferenceManager(this).saveUserToken("")
            startActivity(Intent(this, MainActivity::class.java).apply {
                this.flags =
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }

    override fun setMessage(message: String) {
        welcomeText.text = message
    }
}