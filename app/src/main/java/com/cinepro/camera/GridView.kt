package com.cinepro.camera

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GridView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.WHITE
        strokeWidth = 2f
        alpha = 100
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()

        // Vertical lines
        canvas.drawLine(width / 3, 0f, width / 3, height, paint)
        canvas.drawLine(2 * width / 3, 0f, 2 * width / 3, height, paint)

        // Horizontal lines
        canvas.drawLine(0f, height / 3, width, height / 3, paint)
        canvas.drawLine(0f, 2 * height / 3, width, 2 * height / 3, paint)
    }
}
