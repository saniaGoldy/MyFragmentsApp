package com.example.myfragmentsapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColourViewModel : ViewModel() {
    // Create a LiveData with a String
    val currentColour: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getColour(): MutableLiveData<Boolean> {
        return currentColour
    }

    val userInput: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getInput(): MutableLiveData<String>{
        return userInput
    }
}