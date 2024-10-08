package com.julian.eventme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.julian.myevent.ListEventsItem
import com.julian.myevent.R

class EventAdapter(private val events: List<ListEventsItem>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_event_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.text_event_description)
        val dateTextView: TextView = itemView.findViewById(R.id.text_event_date)
        val imageView: ImageView = itemView.findViewById(R.id.event_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.nameTextView.text = event.name
        holder.descriptionTextView.text = event.description
        holder.dateTextView.text = event.beginTime

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(event.mediaCover)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
