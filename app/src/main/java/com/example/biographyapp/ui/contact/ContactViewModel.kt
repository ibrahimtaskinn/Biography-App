package com.example.biographyapp.ui.contact

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class ContactViewModel @Inject constructor(@ApplicationContext val context: Context) : ViewModel() {

    private val _emailSent = MutableLiveData<Boolean>()
    val emailSent: LiveData<Boolean> = _emailSent
    val defaultEmailAddress = "taskinnibrahim@gmail.com"

    fun sendEmail(message: String) {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(defaultEmailAddress))
            putExtra(Intent.EXTRA_SUBJECT, "Biography App Feedback")
            putExtra(Intent.EXTRA_TEXT, message)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        if (emailIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(Intent.createChooser(emailIntent, "Choose an Email client:").apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })
            _emailSent.value = true
        }
    }

    fun resetEmailSent() {
        _emailSent.value = false
    }
}