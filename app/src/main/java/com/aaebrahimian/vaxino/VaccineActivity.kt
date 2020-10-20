package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class VaccineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)

        val btn_Vaccine_1 = findViewById<Button>(R.id.btn_Vaccine_1)
        val btn_Vaccine_2 = findViewById<Button>(R.id.btn_Vaccine_2)
        val btn_Vaccine_3 = findViewById<Button>(R.id.btn_Vaccine_3)
        val btn_Vaccine_4 = findViewById<Button>(R.id.btn_Vaccine_4)
        val btn_Vaccine_5 = findViewById<Button>(R.id.btn_Vaccine_5)

        btn_Vaccine_1.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_2.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_3.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_4.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_5.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }


    }
}