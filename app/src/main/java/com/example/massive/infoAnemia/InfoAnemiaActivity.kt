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
                "Apa itu anemia?"
            ),
            InfoAnemia_Model(
                R.drawable.info2,
                "Apa saja jenis jenis anemia?",

            ),
            InfoAnemia_Model(
                R.drawable.info3,
                "Cara mencegah anemia",

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