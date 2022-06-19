package com.example.myfragmentsapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myfragmentsapp.R

class ButtonsFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonsFragment()
    }

    private var firstFragmentDisplayed = true
    private val model: ColourViewModel by activityViewModels()
    private var upColour = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_buttons, container, false)
        val colouredFragment1 = ColouredFragment1()
        val colouredFragment2 = ColouredFragment2.newInstance()
        with(view) {
            findViewById<Button>(R.id.change_fragment_button).setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    firstFragmentDisplayed = if (firstFragmentDisplayed) {
                        replace(R.id.colouredFragContainer, colouredFragment2)
                        false
                    } else {
                        replace(R.id.colouredFragContainer, colouredFragment1)
                        true
                    }
                }.addToBackStack(null).commit()
            }

            findViewById<Button>(R.id.change_colour_button).setOnClickListener {
                model.currentColour.value = upColour
                upColour = !upColour
            }
            return view
        }
    }

}