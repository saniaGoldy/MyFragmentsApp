package com.example.myfragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfragmentsapp.ui.main.ColouredFragment1

const val TAG = "MyApp"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.colouredFragContainer, ColouredFragment1.newInstance())
                .commitNow()
        }
    }
}