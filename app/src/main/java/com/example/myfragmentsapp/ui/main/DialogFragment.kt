package com.example.myfragmentsapp.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.myfragmentsapp.R

class DialogFragment : DialogFragment() {
    private val model: ColourViewModel by activityViewModels()
    lateinit var editText: EditText
    var currText = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: inflating view")
        val view = inflater.inflate(R.layout.create_list_alert_dialog, container)
        isCancelable = false
        with(view) {
            findViewById<Button>(R.id.cancel_button).setOnClickListener {
                Log.d(TAG, "cancelDialogButton clicked")
                this@DialogFragment.dismiss()
            }
            val createButton = findViewById<Button>(R.id.confirm_button)

            editText = findViewById<EditText>(R.id.dialogEditText).also {
                it.addTextChangedListener(getTextWatcher(createButton))
            }

            createButton.setOnClickListener {
                model.userInput.value = currText
                this@DialogFragment.dismiss()
            }
        }
        return view
    }

    private fun getTextWatcher(createButton: Button) = object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
            Log.d(TAG, "beforeTextChanged: ")

        }

        override fun onTextChanged(
            s: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
            Log.d(TAG, "onTextChanged: ")

        }

        override fun afterTextChanged(s: Editable?) {
            Log.d(TAG, "afterTextChanged: $s")
            if (s != null) {
                if (s.length > 3) {
                    createButton.isClickable = true
                } else {
                    createButton.isClickable = false
                    Toast.makeText(
                        requireContext(),
                        "input more than three characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                currText = s.toString()
            }
        }

    }


    companion object {
        const val TAG = "FDialog"
    }
}