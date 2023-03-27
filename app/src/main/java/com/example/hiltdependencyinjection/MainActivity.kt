package com.example.hiltdependencyinjection

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
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

        findViewById<TextView>(R.id.titleTextView).apply {
            text = someClass.doAThing()
        }
    }
}


class SomeClass
@Inject
constructor(
    private val someInterfaceOneImpl: SomeInterfaceOne,
    private val someInterfaceTwoImpl: SomeInterfaceTwo
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceOneImpl.getAThing()} and ${someInterfaceTwoImpl.getAThing()}"
    }
}

class SomeInterfaceOneImpl @Inject constructor(): SomeInterfaceOne {
    override fun getAThing() : String{
        return "A Thing One"
    }
}

class SomeInterfaceTwoImpl @Inject constructor(private val gson: Gson): SomeInterfaceTwo {
    override fun getAThing() : String{
        return "A Thing Two + ${gson.hashCode()}"
    }
}

interface SomeInterfaceOne{
    fun getAThing(): String
}

interface SomeInterfaceTwo{
    fun getAThing(): String
}