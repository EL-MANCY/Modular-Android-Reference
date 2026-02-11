package com.elmancy.modular_android_reference.presentation.features.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.elmancy.modular_android_reference.R
import com.elmancy.modular_android_reference.databinding.FragmentRegisterBinding
import com.elmancy.presentation.fragment.CoreFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : CoreFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: AuthViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val pass = binding.passwordInputLayout.editText?.text.toString()

            viewModel.register(name, pass)
        }

        binding.backLogin.setOnClickListener {
            findNavController().navigate(R.id.RegisterToSignInNav)
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