package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InformationClinicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_clinic)

        var img_Clinic = findViewById<ImageView>(R.id.img_Clinic)
        var txt_Information = findViewById<TextView>(R.id.txt_Information_Clinic)
        val btn_Call = findViewById<Button>(R.id.btn_Call)
        val btn_Back = findViewById<Button>(R.id.btn_Back)
        val btn_Selection = findViewById<Button>(R.id.btn_Selection)


        btn_Call.setOnClickListener {

        }

        btn_Back.setOnClickListener {

        }

        btn_Selection.setOnClickListener {

        }


    }
}