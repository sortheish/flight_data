package com.example.assignmentflight.request

import com.example.assignmentflight.models.FlightList
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Ishwari Sorthe
 * Interface which contains set of request quires(function) with endpoints
 */
interface FlightService {

 @GET("/v3/launches")
 suspend fun getFlight():Response<FlightList>

}