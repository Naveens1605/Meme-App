package com.example.memeapp.repository

import com.example.memeapp.services.MemeService

class MemeRepository {

    private lateinit var url : String
    private var getMeme = MemeService.getInstance()

    fun getMeme(): String {
        url = getMeme.getMeme()
        return url
    }
}