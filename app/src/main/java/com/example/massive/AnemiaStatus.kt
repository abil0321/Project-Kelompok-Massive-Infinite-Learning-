package com.example.massive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.databinding.ActivityAnemiaStatusBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class AnemiaStatus : AppCompatActivity() {
    private lateinit var binding: ActivityAnemiaStatusBinding
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnemiaStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }
        binding.btnPerbaharui.setOnClickListener {
            startActivity(Intent(this, InputDataHb::class.java))
        }
        lineChart = binding.lineChart
        setupLineChart()
    }
    private fun setupLineChart() {
        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)

        val xAxis: XAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        val yAxisRight: YAxis = lineChart.axisRight
        yAxisRight.isEnabled = false

        val entries = mutableListOf<Entry>()
        entries.add(Entry(1f, 9f))
        entries.add(Entry(2f, 15f))
        entries.add(Entry(3f, 17f))
        entries.add(Entry(4f, 12f))

        val dataSet = LineDataSet(entries, "Hemoglobin")

        dataSet.setColors(intArrayOf(android.R.color.holo_purple), this)

        val lineData = LineData(dataSet)
        lineChart.data = lineData
    }
}