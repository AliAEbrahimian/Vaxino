package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img_Main = findViewById<ImageView>(R.id.img_Main)
        val btn_Start_Vaccine = findViewById<Button>(R.id.btn_Start_Vaccine)
        val btn_Follow_Up = findViewById<Button>(R.id.btn_Follow_Up)
        val txt_Main = findViewById<TextView>(R.id.txt_Main)

        txt_Main.alpha = 0f
        txt_Main.animate().setDuration(1500).alpha(1f)
        txt_Main.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Main.text = "Description:\n" +
                "1. By pressing the START VACCINE button you will enter the vaccination stage\n" +
                "2. By pressing the SEARCH button you will recover your data"

        btn_Start_Vaccine.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Start_Vaccine.setOnClickListener {
            val intent = Intent (this, SelectActivity::class.java)
            startActivity(intent)
        }

        btn_Follow_Up.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Follow_Up.setOnClickListener {

        }
    }
}
