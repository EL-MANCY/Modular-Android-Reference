package com.elmancy.modular_android_reference.presentation.features.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.elmancy.modular_android_reference.R
import com.elmancy.modular_android_reference.databinding.FragmentSignInBinding
import com.elmancy.modular_android_reference.presentation.features.register.AuthViewModel
import com.elmancy.presentation.fragment.CoreFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : CoreFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    private val viewModel: AuthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val pass = binding.passwordInputLayout.editText?.text.toString()
            viewModel.login(name, pass)
        }

        binding.textView7.setOnClickListener {
            findNavController().navigate(R.id.SignInToRegisterNav)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.events.collect { result ->
                when (result) {
                    is AuthViewModel.AuthEvent.Loading -> {
                        binding.button.isLoading(result.isLoading)
                    }
                    is AuthViewModel.AuthEvent.Success -> {
                        Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                    }

                    is AuthViewModel.AuthEvent.Error -> {
                        Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}