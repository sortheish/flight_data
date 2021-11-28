package com.example.assignmentflight.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.assignmentflight.models.FlightList
import com.example.assignmentflight.repositories.FlightRepository
import com.example.assignmentflight.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch

/**
 * @author Ishwari Sorthe
 * Class view model extend form BaseViewModel which required repository instance
 */
class FlightViewModel(private val repository: FlightRepository) : BaseViewModel<UiState>() {

    /**
     * Calling only one api that's why used init block instead of function
     */
    init {
        uiState.value = UiState.Loading
        /**
         * Used viewModelScope to launch on main thread
         * @exception TimeoutCancellationException , Exception
         */
        viewModelScope.launch(Dispatchers.Main) {
            try {
                /**Requesting repository get list of flight*/
                repository.getFlight()
                uiState.postValue(UiState.Success(flight))
            } catch (exception: TimeoutCancellationException) {
                uiState.postValue(UiState.Error("Network Request timeout!"))
            } catch (exception: Exception) {
                uiState.postValue(UiState.Error("Network Request failed!"))
            }
        }
    }

    /**@property FlightList*/
    private val flight: LiveData<FlightList>
        get() = repository.flights
}