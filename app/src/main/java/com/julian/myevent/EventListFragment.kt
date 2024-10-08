package com.julian.myevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.julian.eventme.EventAdapter

class EventListFragment : Fragment() {

    private lateinit var eventViewModel: EventViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_list, container, false)

        // Initialize RecyclerView and ProgressBar
        recyclerView = view.findViewById(R.id.recycler_view_events)
        progressBar = view.findViewById(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Initialize ViewModel
        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)


        eventViewModel.events.observe(viewLifecycleOwner) { events ->
            recyclerView.adapter = EventAdapter(events)
        }

        eventViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        eventViewModel.fetchEvents(0)

        return view
    }
}
