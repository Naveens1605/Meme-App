package com.example.memeapp.utils

import com.example.memeapp.interfaces.ViewModelCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadMeme (private val variables: Variables) {

    fun loadMeme(){
        variables.viewModel.getMeme(object : ViewModelCallback{
            override suspend fun onSuccess() {
                variables.currentMeme = variables.viewModel.url
                withContext(Dispatchers.Main) {
                    variables.showMeme.showMeme(variables.viewModel.url)
                }
            }
        })
    }
}
