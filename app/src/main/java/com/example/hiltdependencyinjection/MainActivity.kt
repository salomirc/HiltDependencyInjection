package com.example.hiltdependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    // field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, someClass.doAThing())
        Log.d(TAG, someClass.doSomeOtherThing())
    }
}


// constructor injection
class SomeClass @Inject constructor(
    private val someOtherClass: SomeOtherClass
) {

    fun doAThing(): String = "Look I did a thing!"
    fun doSomeOtherThing(): String = someOtherClass.doSomeOtherThing()
}

class SomeOtherClass @Inject constructor() {
    fun doSomeOtherThing(): String = "Look I did some other thing!"
}