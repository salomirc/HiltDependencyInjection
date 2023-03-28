package com.example.hiltdependencyinjection.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hiltdependencyinjection.R

class MainFragment(
    private val someString: String
    ) : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Here is some string: $someString")
    }

    companion object {
        private const val TAG = "AppDebug"
    }
}