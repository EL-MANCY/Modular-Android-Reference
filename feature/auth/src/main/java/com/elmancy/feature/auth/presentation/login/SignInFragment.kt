package com.elmancy.feature.auth.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.elmancy.feature.auth.R
import com.elmancy.feature.auth.databinding.FeatureAuthFragmentSignInBinding
import com.elmancy.feature.auth.presentation.AuthViewModel
import com.elmancy.presentation.fragment.CoreFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : CoreFragment<FeatureAuthFragmentSignInBinding>(
    FeatureAuthFragmentSignInBinding::inflate
) {

    private val viewModel: AuthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignIn.setOnClickListener {
            val name = binding.editTextText.text
            val pass = binding.etPassword.text
            viewModel.login(name, pass)
        }

        binding.textView7.setOnClickListener {
            findNavController().navigate(R.id.SignInToRegisterNav)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.events.collect { result ->
                when (result) {
                    is AuthViewModel.AuthEvent.Loading -> {
                        binding.btnSignIn.isLoading(result.isLoading)
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

