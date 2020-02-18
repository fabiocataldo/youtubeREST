package com.example.kotlinyoutube.Presenter

import com.example.kotlinyoutube.HomeFeed
import com.example.kotlinyoutube.MainAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

fun fetchJson() {

    val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

    val request = Request.Builder().url(url).build()

    val client = OkHttpClient()

    client.newCall(request).enqueue(object : Callback {

        override fun onResponse(call: Call, response: Response) {
            val body = response.body?.string()

            val gson = GsonBuilder().create()
            val homeFeed = gson.fromJson(body, HomeFeed::class.java)

        }
        override fun onFailure(call: Call, e: IOException) {
            println("FAILED ATTEMPTING")
        }
    })
}