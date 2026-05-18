package com.elmancy.modular_android_reference.presentation

import android.os.Bundle
import com.elmancy.modular_android_reference.databinding.ActivityMainBinding
import com.elmancy.presentation.activity.CoreActivity

class MainActivity : CoreActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}