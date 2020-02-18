package com.example.kotlinyoutube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(var homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed.videos[position]
        holder.view.textView_video_title.text = video.nameExample
        holder.view.textView_channel_name.text = video.channel.name

        val thumbnailImageView = holder.view.imageView_thumbnail
        Picasso.get()
            .load(video.imageUrl)
            .into(thumbnailImageView)
        val profileImageView = holder.view.imageView_channel_profile
        Picasso.get()
            .load(video.channel.profileImageUrl)
            .into(profileImageView)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}