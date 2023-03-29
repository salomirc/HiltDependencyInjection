package com.example.hiltdependencyinjection.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltdependencyinjection.R
import dagger.hilt.android.AndroidEntryPoint


// This annotation is required because we have a fragment down the view tree
// that uses @AndroidEntryPoint annotation to achieve DI with Hilt
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}