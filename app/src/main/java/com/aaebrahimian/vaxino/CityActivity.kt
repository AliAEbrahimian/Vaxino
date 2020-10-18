package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class CityActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        val btn_City_1 = findViewById<Button>(R.id.btn_City_1)
        val btn_City_2 = findViewById<Button>(R.id.btn_City_2)
        val btn_City_3 = findViewById<Button>(R.id.btn_City_3)
        val btn_City_4 = findViewById<Button>(R.id.btn_City_4)
        val btn_City_5 = findViewById<Button>(R.id.btn_City_5)

        btn_City_1.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_2.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_3.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_4.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_5.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        val btn_Back = findViewById<Button>(R.id.btn_Back)

        btn_Back.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}