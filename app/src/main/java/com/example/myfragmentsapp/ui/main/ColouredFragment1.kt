package com.example.myfragmentsapp.ui.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.myfragmentsapp.R
import com.example.myfragmentsapp.TAG

class ColouredFragment1 : Fragment() {
    private var yellowColourDisplayed = false
    private val model: ColourViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val colourObserver = Observer<Boolean> {
            yellowColourDisplayed = it
            changeColour()
        }

        model.currentColour.observe(this, colourObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coloured1, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeColour() {
        Log.d(TAG, "changeColour: Fragment1")
        this.view?.apply {
            yellowColourDisplayed = if (yellowColourDisplayed) {
                setBackgroundColor(resources.getColor(R.color.yellow, null))
                false
            } else {
                setBackgroundColor(resources.getColor(R.color.blue, null))
                true
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ColouredFragment1()
    }
}