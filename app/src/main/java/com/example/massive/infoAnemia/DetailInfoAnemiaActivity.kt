package com.example.massive.infoAnemia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.massive.R

class DetailInfoAnemiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_info_anemia)

        val detailinfo = intent.getParcelableExtra<InfoAnemia_Model>(InfoAnemiaActivity.INTENT_PARCELABLE)

        val imgInfoAnemia = findViewById<ImageView>(R.id.img_item_photo)
        val titleInfoAnemia = findViewById<TextView>(R.id.tv_item_name)
        val descInfoAnemia = findViewById<TextView>(R.id.tv_item_description)

        titleInfoAnemia.setOnClickListener {
            val intent = Intent(this, InfoAnemiaActivity::class.java)
            startActivity(intent)
        }

        imgInfoAnemia.setImageResource(detailinfo?.imgInfoAnemia!!)
        titleInfoAnemia.text = detailinfo.titleInfoAnemia
        descInfoAnemia.text = detailinfo.descInfoAnemia
    }
}