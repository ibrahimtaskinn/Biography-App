package com.example.biographyapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _openUrl = MutableLiveData<String>()
    val openUrl: LiveData<String> = _openUrl

    var isLinkedInClicked = false

    fun openLinkedIn() {
        isLinkedInClicked = true
        viewModelScope.launch {
            val linkedInUrl = "https://www.linkedin.com/in/ibrahimtaskin/"
            _openUrl.value = linkedInUrl
        }
    }
}