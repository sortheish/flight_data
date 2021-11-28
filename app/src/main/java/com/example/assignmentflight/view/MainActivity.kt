package com.example.assignmentflight.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentflight.R
import com.example.assignmentflight.adapter.FlightAdapter
import com.example.assignmentflight.factory.FlightViewModelFactory
import com.example.assignmentflight.repositories.FlightRepository
import com.example.assignmentflight.request.FlightService
import com.example.assignmentflight.request.RetrofitHelper
import com.example.assignmentflight.utils.UiState
import com.example.assignmentflight.viewmodels.FlightViewModel

/**
 * @author Ishwari Sorthe
 */
class MainActivity : AppCompatActivity() {

    private lateinit var flightViewModel: FlightViewModel
    private lateinit var adapter: FlightAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flightService = RetrofitHelper.getInstance().create(FlightService::class.java)
        val repository = FlightRepository(flightService)

        /** Initialised the FlightViewModel using view model {@FlightViewModelFactory}*/
        flightViewModel = ViewModelProvider(
            this, FlightViewModelFactory(repository)
        )[FlightViewModel::class.java]

        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        /** Observing the UiState - observer will get the updated state in case of data change*/
        flightViewModel.uiState().observe(this, { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })
    }

    /**
     * function to identify the UiState as per the response
     * @param uiState
     */
    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }

    /**
     * function to perform on progress activity of request call
     */
    private fun onLoad() {
        progressBar.visibility = View.VISIBLE
    }

    /**
     * function to perform the task after success of request call
     * @param uiState of UiState.Success
     */
    private fun onSuccess(uiState: UiState.Success) {
        progressBar.visibility = View.GONE

        uiState.flightList.value?.let {
            adapter = FlightAdapter(it, this)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    /**
     * function to perform the task after error case of request call
     * @param uiState of UiState.Error
     */
    private fun onError(uiState: UiState.Error) {
        progressBar.visibility = View.GONE
        Toast.makeText(this, uiState.message, Toast.LENGTH_SHORT).show()
    }
}
