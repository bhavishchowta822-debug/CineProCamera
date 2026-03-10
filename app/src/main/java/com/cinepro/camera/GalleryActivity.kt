package com.cinepro.camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cinepro.camera.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.galleryRecyclerView.layoutManager = GridLayoutManager(this, 3)
        // The adapter for the RecyclerView would be implemented here to display videos

        binding.backToCameraButton.setOnClickListener {
            finish()
        }
    }
}
