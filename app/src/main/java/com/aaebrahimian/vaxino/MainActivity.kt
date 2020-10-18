package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img_Main = findViewById<ImageView>(R.id.img_Main)
        val txt_Main = findViewById<TextView>(R.id.txt_Main)
        val btn_Start_Vaccine = findViewById<Button>(R.id.btn_Start_Vaccine)
        val btn_Follow_Up = findViewById<Button>(R.id.btn_Follow_Up)



        btn_Start_Vaccine.setOnClickListener {
            val intent = Intent (this, CityActivity::class.java)
            startActivity(intent)
        }

        btn_Follow_Up.setOnClickListener {

        }
    }
}
