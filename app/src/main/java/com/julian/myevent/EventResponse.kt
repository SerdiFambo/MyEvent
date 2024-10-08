package com.julian.eventme

import com.google.gson.annotations.SerializedName
import com.julian.myevent.ListEventsItem

data class EventResponse(
    @SerializedName("listEvents")
    val listEvents: List<ListEventsItem> = listOf()
)


