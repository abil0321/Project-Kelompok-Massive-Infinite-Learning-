package com.example.massive.infoAnemia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.massive.R

class InfoAnemiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_anemia)

        val infoanemialist = listOf<InfoAnemia_Model>(
            InfoAnemia_Model(
                R.drawable.hekker,
                "Hekker",
                "penghekker aplikasi",
                "20 November 2021",
                "Baca"
            ),
            InfoAnemia_Model(
                R.drawable.hawkeye_01ab,
                "Hawkeye",
                "Tukang panah tak kena-kena",
                "22 November 2021",
                "Baca"
            ),
            InfoAnemia_Model(
                R.drawable.jatoh,
                "Orang Jatoh",
                "Orang jatoh gajelas dari mana",
                "20 November 2021",
                "Baca"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = InfoAnemia_Adapter(this, infoanemialist){

        }
    }
}