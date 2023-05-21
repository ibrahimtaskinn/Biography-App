package com.example.biographyapp.ui.contact

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.biographyapp.R
import com.example.biographyapp.databinding.FragmentContactBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : Fragment(R.layout.fragment_contact) {
    private val viewModel: ContactViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentContactBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.emailAddress.apply {
            setText(viewModel.defaultEmailAddress)
            isFocusable = false
            isFocusableInTouchMode = false
            isLongClickable = false
        }

        binding.sendEmailButton.setOnClickListener {
            viewModel.sendEmail(
                binding.emailAddress.text.toString()
            )
        }

        viewModel.emailSent.observe(viewLifecycleOwner, { emailSent ->
            if (emailSent) {
                binding.message.text.clear()
                viewModel.resetEmailSent()
            }
        })
    }
}
