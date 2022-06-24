package com.example.myfragmentsapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColourViewModel : ViewModel() {
    // Create a LiveData with a String
    val currentColour: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val userInput: MutableLiveData<String> = MutableLiveData<String>()
}