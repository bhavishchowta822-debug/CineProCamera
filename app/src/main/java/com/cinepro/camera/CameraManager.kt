package com.cinepro.camera

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.util.Log

class CameraManager(private val context: Context) {

    fun getCameraIds(): Array<String> {
        val manager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            return manager.cameraIdList
        } catch (e: CameraAccessException) {
            Log.e("CameraManager", "Failed to access camera.", e)
        }
        return arrayOf()
    }

    fun getCameraCharacteristics(cameraId: String): CameraCharacteristics? {
        val manager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            return manager.getCameraCharacteristics(cameraId)
        } catch (e: CameraAccessException) {
            Log.e("CameraManager", "Failed to get camera characteristics.", e)
        }
        return null
    }
}
