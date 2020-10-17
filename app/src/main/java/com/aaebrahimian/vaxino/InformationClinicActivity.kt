package com.aaebrahimian.vaxino

import android.app.Activity
import android.os.Bundle
import android.widget.Button

class InformationClinicActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_clinic)

        val btn_Call = findViewById<Button>(R.id.btn_Call)
        val btn_Back = findViewById<Button>(R.id.btn_Back)
        val btn_Information = findViewById<Button>(R.id.btn_Selection)

    }
}