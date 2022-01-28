package com.example.flowstestclass.presentation

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.flowstestclass.R
import com.example.flowstestclass.domain.getAddNewsUseCase
import com.example.flowstestclass.domain.getNewsUseCase

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel = MainViewModel(
        getNewsUseCase = getNewsUseCase(),
        addNewsUseCase = getAddNewsUseCase()
    )

    private val mainTextView: TextView by lazy { findViewById(R.id.mainTextView) }
    private val editText: EditText by lazy { findViewById(R.id.editText) }

    override fun onStart() {
        super.onStart()
        viewModel.news.observe(this) { news ->
            mainTextView.text = news.toString()
        }

        editText.addTextChangedListener { text ->
            if (text.toString().length == 6) {
                viewModel.addNews(text.toString())
            }
        }

    }
}