package com.elmancy.modular_android_reference.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.elmancy.modular_android_reference.R
import com.elmancy.modular_android_reference.databinding.ActivityMainBinding
import com.elmancy.presentation.CoreActivity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : CoreActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.userProfile.collect { user ->
                if (user == null) {
                    binding.tvResult.text = "Current User: [Empty]"
                } else {
                    binding.tvResult.text = "User: ${user.name}\nAge: ${user.age}\n"
                }
            }
        }
    }

    private fun getValues() {
        lifecycleScope.launch{
            viewModel.getInt().collect {
                binding.tvResult.text = it.toString()
            }
        }
    }
}