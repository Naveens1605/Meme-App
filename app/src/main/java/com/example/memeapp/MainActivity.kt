package com.example.memeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.memeapp.utils.LoadMeme
import com.example.memeapp.utils.ShowMeme
import com.example.memeapp.utils.Variables
import com.example.memeapp.viewmodel.MemeViewModel

class MainActivity : AppCompatActivity() {

    private val variables = Variables()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variables.progressBar = findViewById(R.id.progress_circular)

        variables.imageView = findViewById(R.id.imageView)
        variables.viewModel = ViewModelProvider(this).get(MemeViewModel::class.java)
        variables.showMeme = ShowMeme(this,variables)
        variables.loadMeme = LoadMeme(variables)
        variables.loadMeme.loadMeme()
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.nextMeme -> {
                variables.url = variables.viewModel.url
                variables.progressBar.visibility = View.VISIBLE
                variables.loadMeme.loadMeme()
            }
            R.id.shareMeme -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,variables.currentMeme)
                val chooser = Intent.createChooser(intent,"Share this meme using...")
                startActivity(chooser)
            }
            R.id.previousMeme -> {
                if(variables.url != null){
                    variables.currentMeme = variables.url!!
                    variables.progressBar.visibility = View.VISIBLE
                    variables.showMeme.showMeme(variables.url!!)
                }
            }
        }
    }
}