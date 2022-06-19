package com.example.myfragmentsapp.ui.main

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.KeyListener
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
            val createButt = findViewById<Button>(R.id.confirm_button)

            editText = findViewById<EditText>(R.id.dialogEditText).also{
                it.addTextChangedListener(object : TextWatcher {
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
                                createButt.isClickable = true
                            } else {
                                createButt.isClickable = false
                                Toast.makeText(
                                    requireContext(),
                                    "input more than three characters",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            currText = s.toString()
                        }
                    }

                })
            }

            createButt.setOnClickListener {
                model.userInput.value = currText
                this@DialogFragment.dismiss()
            }
        }
        return view
    }
    companion object {
        const val TAG = "FDialog"
    }
}