package com.example.assignmentflight.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Ishwari Sorthe
 * Base class for View Model
 */
open class BaseViewModel<T> : ViewModel() {
    /**
     * function to check uiState
     * @return LiveData T
     */
    fun uiState(): LiveData<T> = uiState

    /**Mutable live data field as T */
    protected val uiState: MutableLiveData<T> = MutableLiveData()
}