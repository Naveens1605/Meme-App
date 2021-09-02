package com.example.memeapp.services

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MemeService private constructor() {

    companion object {

        private const val url = "https://meme-api.herokuapp.com/gimme"

        @Volatile
        private var INSTANCE: MemeService? = null
        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MemeService().also {
                    INSTANCE = it
                }
            }
    }

    fun getMeme(): String {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        val response = client.newCall(request).execute()

        val jsonObject = JSONObject(response.body?.string()!!)

        return jsonObject.getString("url")
    }
}