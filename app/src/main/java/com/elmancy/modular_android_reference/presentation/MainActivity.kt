package com.elmancy.modular_android_reference.presentation

import android.os.Bundle
import com.elmancy.modular_android_reference.databinding.ActivityMainBinding
import com.elmancy.presentation.activity.CoreActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : CoreActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}