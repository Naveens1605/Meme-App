package com.example.memeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.memeapp.interfaces.ViewModelCallback
import com.example.memeapp.repository.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MemeViewModel : ViewModel() {

    lateinit var url : String
    private var memeRepository : MemeRepository = MemeRepository()

    fun getMeme(viewModelCallBack : ViewModelCallback) = GlobalScope.launch(Dispatchers.IO) {
        url = memeRepository.getMeme()
        viewModelCallBack.onSuccess()
    }
}