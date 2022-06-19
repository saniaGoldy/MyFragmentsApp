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


class ColouredFragment2 : Fragment() {
    private var blackColourDisplayed = false
    private val model: ColourViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val colourObserver = Observer<Boolean> {
            blackColourDisplayed = it
            changeColour()
        }

        model.currentColour.observe(this, colourObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coloured2, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeColour() {
        Log.d(TAG, "changeColour: Fragment2")
        this.view?.apply {
            blackColourDisplayed = if (blackColourDisplayed) {
                setBackgroundColor(resources.getColor(R.color.red, null))
                false
            } else {
                setBackgroundColor(resources.getColor(R.color.black, null))
                true
            }
        }
    }

    companion object {
        fun newInstance() = ColouredFragment2()
    }
}