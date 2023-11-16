package com.example.massive

import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class AnemiaStatus : AppCompatActivity() {

    lateinit var barChart : BarChart
    lateinit var barData : BarData
    lateinit var barDataSet : BarDataSet
    lateinit var barEnteriesList: ArrayList<BarEntry>


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_anemia_status)

        barChart = findViewById(R.id.idBarChart)

        getBarChartData()

        barDataSet= BarDataSet(barEnteriesList, "Bar Chart Data")
        barDataSet.color= Color.parseColor("#FF5733")
        barData= BarData(barDataSet)

        barChart.data= barData
        barDataSet.ValueTextColor= Color.BLACK
        barDataSet.ValueTextSize= 16f
        barChart.description.isEnable= false

        val xAxis= barChart.xAxis
        xAxis.position= XAxis.XAxisPosition.BOTTOM
        xAxis.granularity= 1f
        xAxis.isGranularityEnable= true
        xAxis.labelCount= barEnteriesList.size
        xAxis.valueFormatter= IndexAxisValueFormatter(getXAxisLabels())

    }

    private fun getBarChartData(){
        barEnteriesList= ArrayList()

        barEnteriesList.add(BarEntry(1f,5f))
        barEnteriesList.add(BarEntry(2f,4f))
        barEnteriesList.add(BarEntry(3f,3f))
        barEnteriesList.add(BarEntry(4f,4f))
        barEnteriesList.add(BarEntry(5f,5f))
        barEnteriesList.add(BarEntry(6f,6f))
        barEnteriesList.add(BarEntry(7f,7f))
    }

    private fun getXAxisLabels():List<String>{
        return listOf("","Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu","Minggu")

    }
}