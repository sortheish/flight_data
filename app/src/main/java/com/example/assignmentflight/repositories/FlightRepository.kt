package com.example.assignmentflight.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignmentflight.models.FlightList
import com.example.assignmentflight.request.FlightService

/**
 * @author Ishwari Sorthe
 * This class is the repository class which provides the data
 * to ViewModel
 *
 */
class FlightRepository(private val flightService: FlightService) {
    private val flightLiveData = MutableLiveData<FlightList>()

    /**@property FlightList*/
    val flights: LiveData<FlightList>
        get() = flightLiveData

    /**
     * function to update the mutable live data FlightList
     * using postValue as the operation will be performed on background thread
     */
    suspend fun getFlight() {
        val result = flightService.getFlight()
        if (result.body() != null) {
            flightLiveData.postValue(result.body())
        }
    }
}