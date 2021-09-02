package com.example.memeapp.utils

import android.widget.ImageView
import android.widget.ProgressBar
import com.example.memeapp.viewmodel.MemeViewModel

class Variables {
    lateinit var loadMeme: LoadMeme
    lateinit var imageView: ImageView
    lateinit var progressBar: ProgressBar
    lateinit var viewModel: MemeViewModel
    lateinit var showMeme: ShowMeme
    var url : String? = null
    lateinit var currentMeme : String
}