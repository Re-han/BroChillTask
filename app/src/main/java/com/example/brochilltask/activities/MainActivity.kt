package com.example.brochilltask.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.brochilltask.R
import com.example.brochilltask.interfaces.ILogin
import com.example.brochilltask.presenter.PLogin
import com.example.brochilltask.util.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), ILogin.View {
    private val context = this
    private var presenter: PLogin? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PLogin(context, this)
        setListeners()
        checkAlreadyLoggedIn()
    }

    private fun checkAlreadyLoggedIn() {
        if (PreferenceManager(context).getUserToken() != null && PreferenceManager(context).getUserToken()
                ?.isNotEmpty() == true
        ) {
            startActivity(Intent(this, WelcomeActivity::class.java).apply {
                this.flags =
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })

        }
    }

    private fun setListeners() {
        loginButton.setOnClickListener { login() }
        signUpButton.setOnClickListener { register() }
        registerTextBtn.setOnClickListener {
            loginLayout.hide()
            signUpLayout.show()
        }
        loginTextBtn.setOnClickListener {
            loginLayout.show()
            signUpLayout.hide()
        }
    }

    private fun login() {
        if (emailLogin.text.isEmpty() && passLogin.text.isEmpty()) {
            Toast.makeText(context, "Fields Cannot be empty", Toast.LENGTH_SHORT).show()
        } else if (emailLogin.text.isEmpty()) {
            Toast.makeText(context, "Email Cannot be empty", Toast.LENGTH_SHORT).show()
        } else if (passLogin.text.isEmpty()) {
            Toast.makeText(context, "Password Cannot be empty", Toast.LENGTH_SHORT).show()
        } else if (!Pattern.matches(Patterns.EMAIL_ADDRESS.toString(), emailLogin.text)) {
            Toast.makeText(context, "Enter a valid email address", Toast.LENGTH_SHORT).show()
        } else if (passLogin.text.length < 6) {
            Toast.makeText(
                context,
                "Password length cannot be less than 6 chars",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            presenter?.login(emailLogin.text.toString().trim(), passLogin.text.toString().trim())
        }
    }

    private fun register() {
        when {
            fName.text.isEmpty() && lName.text.isEmpty() && emailSignUp.text.isEmpty() && passSignup.text.isEmpty() -> {
                Toast.makeText(context, "Fields Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            fName.text.isEmpty() -> {
                Toast.makeText(context, "First Name Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            lName.text.isEmpty() -> {
                Toast.makeText(context, "Last Name Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            fName.text.isEmpty() && lName.text.isEmpty() -> {
                Toast.makeText(context, "Names Field Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            emailSignUp.text.isEmpty() -> {
                Toast.makeText(context, "Email Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            passSignup.text.isEmpty() -> {
                Toast.makeText(context, "Password Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            (!Pattern.matches(Patterns.EMAIL_ADDRESS.toString(), emailSignUp.text)) -> {
                Toast.makeText(context, "Enter a valid email address", Toast.LENGTH_SHORT).show()
            }
            (passSignup.text.length < 6) -> {
                Toast.makeText(
                    context,
                    "Password length cannot be less than 6 chars",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                presenter?.register(
                    fName.text.toString().trim(),
                    lName.text.toString().trim(),
                    emailSignUp.text.toString().trim(),
                    passSignup.text.toString().trim()
                )
            }
        }
    }

    override fun loginSuccess() {
        startActivity(Intent(this, WelcomeActivity::class.java).apply {
            this.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
    }

    override fun registerSuccess() {
        startActivity(Intent(this, WelcomeActivity::class.java).apply {
            this.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
        Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
    }

    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.GONE
    }
}