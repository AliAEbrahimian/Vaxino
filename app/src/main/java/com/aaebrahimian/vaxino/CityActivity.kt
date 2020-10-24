package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class CityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        val txt_City = findViewById<TextView>(R.id.txt_City)

        val btn_City_1 = findViewById<Button>(R.id.btn_City_1)
        val btn_City_2 = findViewById<Button>(R.id.btn_City_2)
        val btn_City_3 = findViewById<Button>(R.id.btn_City_3)
        val btn_City_4 = findViewById<Button>(R.id.btn_City_4)
        val btn_City_5 = findViewById<Button>(R.id.btn_City_5)

        txt_City.text = "\n"+"Choose your city of residence"
        txt_City.typeface = ResourcesCompat.getFont(this,R.font.frission)
        txt_City.alpha = 0f
        txt_City.animate().setDuration(1500).alpha(1f)


        btn_City_1.text = "Isfahan"
        btn_City_1.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_City_1.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_2.text = "Shahin Shahr"
        btn_City_2.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_City_2.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_3.text = "Khomeini Shahr"
        btn_City_3.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_City_3.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_4.text = "Falavarjan"
        btn_City_4.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_City_4.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }

        btn_City_5.text = "Najaf Abad"
        btn_City_5.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_City_5.setOnClickListener {
            val intent = Intent (this, VaccineActivity::class.java)
            startActivity(intent)
        }



    }

}