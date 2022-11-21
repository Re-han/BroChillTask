package com.example.brochilltask.manager

import com.example.example.TweetsResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    private val apiUrl = "https://wern-api.brochill.app/"
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(ApiClass::class.java)

    suspend fun registerUser(map: HashMap<String, Any>): JSONObject {
        return withContext(Dispatchers.IO) {
            val resp = api.registerApi(map).execute()
            return@withContext if (resp.isSuccessful) {
                JSONObject(resp.body()!!.string())
            } else {
                JSONObject(resp.errorBody()!!.string())
            }
        }
    }

    suspend fun loginUser(map: HashMap<String, Any>): JSONObject {
        return withContext(Dispatchers.IO) {
            val resp = api.loginApi(map).execute()
            return@withContext if (resp.isSuccessful) {
                JSONObject(resp.body()!!.string())
            } else {
                JSONObject(resp.errorBody()!!.string())
            }
        }
    }

    suspend fun writeTweet(token: String, map: HashMap<String, Any>): JSONObject {
        return withContext(Dispatchers.IO) {
            val resp = api.writeTweet(token, map).execute()
            return@withContext if (resp.isSuccessful) {
                JSONObject(resp.body()!!.string())
            } else {
                JSONObject(resp.errorBody()!!.string())
            }
        }
    }

    suspend fun getMessage(token: String): JSONObject {
        return withContext(Dispatchers.IO) {
            val resp = api.getMessage(token).execute()
            return@withContext if (resp.isSuccessful) {
                JSONObject(resp.body()!!.string())
            } else {
                JSONObject(resp.errorBody()!!.string())
            }
        }
    }

    suspend fun getTweets(token: String): List<TweetsResponse> {
        return withContext(Dispatchers.IO) {
            val resp = api.getTweets(token).execute()
            return@withContext (if (resp.isSuccessful) {
                resp.body()
            } else {
                Gson().fromJson<List<TweetsResponse>>(
                    resp.errorBody()?.string(),
                    TweetsResponse::class.java
                )
            })!!
        }
    }
}