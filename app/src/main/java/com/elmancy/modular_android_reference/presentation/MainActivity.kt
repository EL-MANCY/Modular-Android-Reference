package com.elmancy.modular_android_reference.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.elmancy.modular_android_reference.R
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etToken = findViewById<EditText>(R.id.etToken)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        lifecycleScope.launch {
            viewModel.tokenFlow.collect { token ->
                if (token.isNullOrEmpty()) {
                    tvResult.text = "Current Token: [Empty]"
                } else {
                    tvResult.text = "Current Token: $token"
                }
            }
        }

        btnSave.setOnClickListener {
            val newToken = etToken.text.toString()
            viewModel.saveToken(newToken)
            etToken.text.clear()
        }
    }
}