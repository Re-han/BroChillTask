package com.example.brochilltask.manager

import com.example.example.TweetsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiClass {
    @POST("register")
    fun registerApi(@Body map: HashMap<String, Any>): Call<ResponseBody>

    @POST("login")
    fun loginApi(@Body map: HashMap<String, Any>): Call<ResponseBody>

    @GET("welcome")
    fun getMessage(@Header("x-api-key") token: String): Call<ResponseBody>

    @GET("tweets")
    fun getTweets(@Header("x-api-key") token: String): Call<List<TweetsResponse>>

    @POST("tweets")
    fun writeTweet(
        @Header("x-api-key") token: String,
        @Body map: HashMap<String, Any>
    ): Call<ResponseBody>
}