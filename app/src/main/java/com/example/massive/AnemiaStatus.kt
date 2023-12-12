package com.example.massive

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.massive.databinding.ActivityAnemiaStatusBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

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
        lineChart = findViewById(R.id.lineChart)

        val lineChart: LineChart = findViewById(R.id.lineChart)

        val entries = mutableListOf<Entry>()
        val random = Random
        for (i in 1..3) {
            entries.add(Entry(i.toFloat(), random.nextFloat() * 18))
    }

        val dataSet = LineDataSet(entries, "Grafik HB")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK

        val lineData = LineData(dataSet)

        lineChart.data = lineData

        val xAxis: XAxis = lineChart.xAxis
        object : ValueFormatter() {
            private val dateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())

            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                val date = Date(value.toLong())
                return dateFormat.format(date)
            }
        }.also { xAxis.valueFormatter = it }
        xAxis.position = XAxis.XAxisPosition.BOTTOM
    }
}
