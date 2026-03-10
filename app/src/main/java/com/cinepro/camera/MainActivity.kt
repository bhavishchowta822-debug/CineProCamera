package com.cinepro.camera

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cinepro.camera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isRecording = false

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

        setupUI()
    }

    private fun setupUI() {
        binding.recordButton.setOnClickListener {
            if (isRecording) {
                stopRecording()
            } else {
                startRecording()
            }
        }

        // Setup sliders and dials for manual controls
        binding.isoSlider.addOnChangeListener { _, value, _ ->
            // Update ISO
            updateManualControl("ISO", value)
        }

        binding.shutterSlider.addOnChangeListener { _, value, _ ->
            // Update Shutter Speed
            updateManualControl("SHUTTER", value)
        }
    }

    private fun startCamera() {
        // Initialize Camera2 logic here
        Toast.makeText(this, "Camera Started", Toast.LENGTH_SHORT).show()
    }

    private fun startRecording() {
        isRecording = true
        binding.recordButton.setImageResource(android.R.drawable.ic_media_pause)
        Toast.makeText(this, "Recording Started", Toast.LENGTH_SHORT).show()
    }

    private fun stopRecording() {
        isRecording = false
        binding.recordButton.setImageResource(android.R.drawable.ic_media_play)
        Toast.makeText(this, "Recording Stopped", Toast.LENGTH_SHORT).show()
    }

    private fun updateManualControl(type: String, value: Float) {
        // Implementation for updating camera parameters
        Log.d("CinePro", "Updating $type to $value")
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
