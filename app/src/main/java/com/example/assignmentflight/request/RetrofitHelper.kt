package com.example.assignmentflight.request

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Ishwari Sorthe
 * Class which will perform Retrofit operation and provides retrofit instance
 */
object RetrofitHelper {

    /**BASE_URL*/
    private const val BASE_URL = "https://api.spacexdata.com"

    /**
     *  function to return retrofit instance
     */
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}