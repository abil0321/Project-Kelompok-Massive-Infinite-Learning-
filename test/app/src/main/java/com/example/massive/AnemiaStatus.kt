package com.example.massive

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.databinding.ActivityAnemiaStatusBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class AnemiaStatus : AppCompatActivity() {
    lateinit var binding: ActivityAnemiaStatusBinding
    lateinit var anemiaStatus: AnemiaStatus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnemiaStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }
        // Find the LineChart view by its ID
        val lineChart = findViewById<LineChart>(R.id.line_chart)

        // Create an array of data points (x, y)
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 4f))
        entries.add(Entry(2f, 8f))
        entries.add(Entry(3f, 6f))
        entries.add(Entry(4f, 2f))
        entries.add(Entry(5f, 7f))

        // Create a LineDataSet to represent the data
        val dataSet = LineDataSet(entries, "My Data")
        dataSet.color = Color.BLUE
        dataSet.setCircleColor(Color.RED)
        dataSet.lineWidth = 2f

        // Create a LineData object with the data set
        val lineData = LineData(dataSet)

        // Set the data for the LineChart
        lineChart.data = lineData

        // Customize the chart appearance
        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)
        lineChart.description = Description().apply {
            text = "Data HB"
        }
        lineChart.invalidate()
    }
}