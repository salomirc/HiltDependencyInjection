package com.example.hiltdependencyinjection.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltdependencyinjection.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.apply {
            fragmentFactory = this@MainActivity.fragmentFactory
            beginTransaction()
                .replace(R.id.main_fragment_container, MainFragment::class.java, null)
                .commit()
        }
    }
}