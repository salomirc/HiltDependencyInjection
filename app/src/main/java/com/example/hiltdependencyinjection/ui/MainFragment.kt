package com.example.hiltdependencyinjection.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hiltdependencyinjection.R
import com.example.hiltdependencyinjection.model.Blog
import com.example.hiltdependencyinjection.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment(private val someString: String) : Fragment(R.layout.fragment_main) {

    // This viewModel is injected by Hilt, so this Fragment need to be annotated
    // with @AndroidEntryPoint
    private val viewModel: MainViewModel by viewModels()

    private lateinit var mainTextView : TextView
    private lateinit var progressBar : ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogsEvent)

        mainTextView = view.findViewById(R.id.mainTextView)
        progressBar = view.findViewById(R.id.progress_bar)

        Log.d(TAG, "Hey look! $someString")
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(false)
                    appendBlogTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?){
        if(message != null) mainTextView.text = message else mainTextView.text = "Unknown error."
    }

    private fun appendBlogTitles(blogs: List<Blog>){
        val sb = StringBuilder()
        for(blog in blogs){
            sb.append(blog.title + "\n")
        }
        mainTextView.text = sb.toString()
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        progressBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

    companion object {
        private const val TAG = "AppDebug"
    }
}