package com.tms.dagger2testan12.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.tms.dagger2testan12.NumbersApplication
import com.tms.dagger2testan12.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NumbersApplication.appComponent?.inject(this)

        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initObservers()
    }

    private fun initObservers() {
        viewModel.numbers.observe(this) { numbers ->
            Toast.makeText(this, numbers.toString(), Toast.LENGTH_LONG).show()
            Snackbar.make(
                findViewById<TextView>(R.id.hw),
                viewModel.getString(),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}