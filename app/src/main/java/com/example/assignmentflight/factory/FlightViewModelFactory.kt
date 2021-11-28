package com.example.assignmentflight.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentflight.repositories.FlightRepository
import com.example.assignmentflight.viewmodels.FlightViewModel

/**
 * @author Ishwari Sorthe
 * View model factory class to initialised the parameterised ViewModel
 */
class FlightViewModelFactory(private val repository: FlightRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FlightViewModel(repository) as T
    }

}