package com.example.brochilltask.util

import android.content.Context
import android.content.SharedPreferences
import android.view.Display

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("token", Context.MODE_PRIVATE)

    fun saveUserToken(value: String) {
        val edit = sharedPreferences.edit()
        edit.putString(Constants.AuthToken, value)
        edit.apply()
    }

    fun getUserToken(): String? {
        return sharedPreferences.getString(Constants.AuthToken, "")
    }
}