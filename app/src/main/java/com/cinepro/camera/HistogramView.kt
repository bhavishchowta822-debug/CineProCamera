package com.cinepro.camera

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class HistogramView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.WHITE
        strokeWidth = 2f
        style = Paint.Style.STROKE
    }

    private var histogramData: IntArray? = null

    fun updateHistogram(data: IntArray) {
        histogramData = data
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        histogramData?.let { data ->
            val width = width.toFloat()
            val height = height.toFloat()
            val step = width / data.size
            val max = data.maxOrNull()?.toFloat() ?: 1f

            for (i in data.indices) {
                val x = i * step
                val y = height - (data[i] / max * height)
                canvas.drawLine(x, height, x, y, paint)
            }
        }
    }
}
