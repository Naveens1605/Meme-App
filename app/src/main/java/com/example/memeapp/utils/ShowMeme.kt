package com.example.memeapp.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class ShowMeme (private val context: Context, private val variables: Variables) {

    fun showMeme(url : String) {
        Glide.with(context).load(url).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Toast.makeText(context,"No Meme Found", Toast.LENGTH_LONG).show()
                variables.progressBar.visibility = View.GONE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                variables.progressBar.visibility = View.GONE
                return false
            }

        }).into(variables.imageView)
    }
}