package com.example.massive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class AnemiaStatus : Fragment() {

    private lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_anemia_status, container, false)
        lineChart = view.findViewById(R.id.lineChart)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLineChart()
        setData()
    }

    private fun setupLineChart() {
        // Customize the line chart as needed
        lineChart.description = Description().apply { text = "Data Hb" }
        lineChart.setNoDataText("No data available")
    }

    private fun setData() {

        val entries = mutableListOf<Entry>()
        entries.add(Entry(1f, 20f))
        entries.add(Entry(2f, 15f))
        entries.add(Entry(3f, 25f))
        entries.add(Entry(4f, 18f))
        entries.add(Entry(5f, 30f))

        val dataSet = LineDataSet(entries, "Example Line Data")
        dataSet.color = resources.getColor(R.color.AliceBlue)
        dataSet.valueTextColor = resources.getColor(android.R.color.black)

        val lineDataSets = ArrayList<ILineDataSet>()
        lineDataSets.add(dataSet)

        val lineData = LineData(lineDataSets)
        lineChart.data = lineData
        lineChart.invalidate()
    }
}
