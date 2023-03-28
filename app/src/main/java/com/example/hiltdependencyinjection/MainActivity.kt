package com.example.hiltdependencyinjection

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltdependencyinjection.dependencies.SomeClassOne
import com.example.hiltdependencyinjection.dependencies.SomeClassTwo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    // field injection
    @Inject
    lateinit var someClassOne: SomeClassOne

    @Inject
    lateinit var someClassTwo: SomeClassTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.titleTextView).apply {
            text = getString(R.string.main_text, someClassOne.doAThing(), someClassTwo.doAThing())
        }
    }
}