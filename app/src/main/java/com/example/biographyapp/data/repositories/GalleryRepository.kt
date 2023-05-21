package com.example.biographyapp.data.repositories

import android.content.Context
import com.example.biographyapp.data.models.Image
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GalleryRepository @Inject constructor(@ApplicationContext val context: Context) {

    suspend fun fetchImages(): List<Image> = withContext(Dispatchers.IO) {
        val urls = listOf(
            "https://picsum.photos/id/10/200/300",
            "https://picsum.photos/id/20/200/300",
            "https://picsum.photos/id/30/200/300",
            "https://picsum.photos/id/45/200/300",
            "https://picsum.photos/id/50/200/300",
            "https://picsum.photos/id/60/200/300",
            "https://picsum.photos/id/70/200/300",
            "https://picsum.photos/id/80/200/300",
            "https://picsum.photos/id/13/200/300",
            "https://picsum.photos/id/26/200/300",
            "https://picsum.photos/id/32/200/300",
            "https://picsum.photos/id/47/200/300",
            "https://picsum.photos/id/53/200/300",
            "https://picsum.photos/id/67/200/300",
            "https://picsum.photos/id/72/200/300",
            "https://picsum.photos/id/88/200/300",
        )

        val images = urls.map { url -> Image(url) }
        return@withContext images
    }
}