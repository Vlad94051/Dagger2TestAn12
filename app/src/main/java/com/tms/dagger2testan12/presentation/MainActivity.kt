package com.tms.dagger2testan12.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.tms.dagger2testan12.NumbersApplication
import com.tms.dagger2testan12.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private val hwView by lazy { findViewById<TextView>(R.id.hw) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NumbersApplication.appComponent?.inject(this)

        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initObservers()

        findViewById<Button>(R.id.btn).setOnClickListener {
            viewModel.onButtonClicked()
        }
    }

    private fun initObservers() {
        viewModel.numbers.observe(this) { strings ->
            hwView.text = strings.toString()
        }
    }
}