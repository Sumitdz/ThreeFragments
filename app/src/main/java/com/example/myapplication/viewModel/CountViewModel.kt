package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    private val mutableLiveData = MutableLiveData<Int>()

    init {
        mutableLiveData.value = 0
    }

    fun getMutableLiveData():LiveData<Int>{
        return mutableLiveData
    }

    fun increment(){
        mutableLiveData.value = mutableLiveData.value!! + 1
    }

    fun decrement(){
        mutableLiveData.value = mutableLiveData.value!! - 1
    }

}