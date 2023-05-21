package com.example.biographyapp.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biographyapp.data.repositories.GalleryRepository
import com.example.biographyapp.data.models.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val galleryRepository: GalleryRepository) : ViewModel() {

    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> get() = _images


    fun loadImages() {
        viewModelScope.launch {
            val fetchedImages = galleryRepository.fetchImages()
            _images.value = fetchedImages
        }
    }
}