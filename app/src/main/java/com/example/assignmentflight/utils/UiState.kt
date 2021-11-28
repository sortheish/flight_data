package com.example.assignmentflight.utils

import androidx.lifecycle.LiveData
import com.example.assignmentflight.models.FlightList

/**
 * @author Ishwari Sorthe
 * Sealed class which will used for different state of request
 */
sealed class UiState {

    /** for loading state*/
    object Loading : UiState()

    /**data class for success request response*/
    data class Success(
        val flightList: LiveData<FlightList>
    ) : UiState()

    /**data class for Error while requesting*/
    data class Error(val message: String) : UiState()
}
