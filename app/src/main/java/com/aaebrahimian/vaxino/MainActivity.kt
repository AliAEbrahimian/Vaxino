package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_Start_Vaccine = findViewById<Button>(R.id.btn_Start_Vaccine)
        val btn_Follow_Up = findViewById<Button>(R.id.btn_Follow_Up)

    }
}