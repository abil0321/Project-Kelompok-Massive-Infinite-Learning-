package com.example.massive.infoAnemia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.massive.R

class InfoAnemiaActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_anemia)

        val infoanemialist = listOf<InfoAnemia_Model>(
            InfoAnemia_Model(
                R.drawable.info,
                "Apa itu anemia?",
                "Anemia merupakan kondisi medis yang terjadi ketika jumlah sel darah merah dalam lebih rendah dari jumlah normal",
                "22 November 2023",
                "Baca"
            ),
            InfoAnemia_Model(
                R.drawable.info2,
                "Apa saja jenis jenis anemia?",
                "Terdapat beberapa jenis anemia yang dapat mempengaruhi individu. Beberapa jenis anemia yang umum meliputi",
                "24 November 2023",
                "Baca"
            ),
            InfoAnemia_Model(
                R.drawable.info3,
                "Cara mencegah anemia",
                "Jika kamu ingin mencegah anemia, sebaiknya perbanyak konsumsi makanan yang kaya akan zat besi. Berikut cara pencegahan anemia",
                "26 November 2023",
                "Baca"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = InfoAnemia_Adapter(this, infoanemialist){
            val intent = Intent (this, DetailInfoAnemiaActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}