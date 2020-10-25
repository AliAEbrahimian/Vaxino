package com.aaebrahimian.vaxino

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class VaccineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)

        val txt_Vaccine = findViewById<TextView>(R.id.txt_Vaccine)
        val btn_Vaccine_1 = findViewById<Button>(R.id.btn_Vaccine_1)
        val btn_Vaccine_2 = findViewById<Button>(R.id.btn_Vaccine_2)
        val btn_Vaccine_3 = findViewById<Button>(R.id.btn_Vaccine_3)
        val btn_Vaccine_4 = findViewById<Button>(R.id.btn_Vaccine_4)
        val btn_Vaccine_5 = findViewById<Button>(R.id.btn_Vaccine_5)
        val btn_Vaccine_6 = findViewById<Button>(R.id.btn_Vaccine_6)
        val btn_Vaccine_7 = findViewById<Button>(R.id.btn_Vaccine_7)

        txt_Vaccine.text = "\n"+"Select the desired vaccine"
        txt_Vaccine.typeface = ResourcesCompat.getFont(this,R.font.frission)
        txt_Vaccine.alpha = 0f
        txt_Vaccine.animate().setDuration(1500).alpha(1f)

        btn_Vaccine_1.text = "BCG"
        btn_Vaccine_1.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_1.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_2.text = "DPT"
        btn_Vaccine_2.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_2.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_3.text = "DT & Td"
        btn_Vaccine_3.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_3.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_4.text = "OPV & IPV"
        btn_Vaccine_4.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_4.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_5.text = "MMR"
        btn_Vaccine_5.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_5.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_6.text = "TT"
        btn_Vaccine_6.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_6.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }

        btn_Vaccine_7.text = "Hep.B"
        btn_Vaccine_7.typeface = ResourcesCompat.getFont(this,R.font.frission)
        btn_Vaccine_7.setOnClickListener {
            val intent = Intent (this, ClinicActivity::class.java)
            startActivity(intent)
        }
    }
}