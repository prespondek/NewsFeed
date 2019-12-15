package com.lanyard.newsfeed.views.adapters

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import androidx.databinding.BindingAdapter


@BindingAdapter("imageHref")
fun bindImageHref(view: ImageView, imageHref: String?) {
    if (!imageHref.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageHref)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}