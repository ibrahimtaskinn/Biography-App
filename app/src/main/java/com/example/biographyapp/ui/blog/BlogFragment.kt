package com.example.biographyapp.ui.blog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.biographyapp.R
import com.example.biographyapp.databinding.FragmentBlogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogFragment : Fragment(R.layout.fragment_blog) {
    private val viewModel: BlogViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBlogBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.blogWebview.settings.javaScriptEnabled = true
        binding.blogWebview.loadUrl(viewModel.blogUrl)
    }
}