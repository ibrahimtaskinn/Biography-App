package com.example.biographyapp.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.biographyapp.R
import com.example.biographyapp.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {
    private val viewModel: GalleryViewModel by viewModels()


    private val galleryAdapter = GalleryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGalleryBinding.bind(view)

        binding.lifecycleOwner = viewLifecycleOwner

        val galleryRecyclerView = binding.galleryRecyclerView
        galleryRecyclerView.adapter = galleryAdapter

        viewModel.images.observe(viewLifecycleOwner, { images ->
            galleryAdapter.submitList(images)
        })

        viewModel.loadImages()
    }
}