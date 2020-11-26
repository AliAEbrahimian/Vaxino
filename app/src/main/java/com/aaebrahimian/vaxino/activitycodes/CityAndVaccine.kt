package com.aaebrahimian.vaxino.activitycodes

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R

class CityAndVaccine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cityandvaccine)

        val txt_City = findViewById<TextView>(R.id.txt_City)
        txt_City.alpha = 0f
        txt_City.animate().setDuration(1500).alpha(1f)
        txt_City.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_City.text = "1. You can select your desired city by hitting the spinner below."

        val spinner_City : Spinner = findViewById(R.id.spinner_City)

        ArrayAdapter.createFromResource(
            this,
                R.array.City_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_City.adapter = adapter
        }
        spinner_City.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                Toast.makeText( this@CityAndVaccine, "You select " , Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText( this@CityAndVaccine, "You not select item" , Toast.LENGTH_SHORT).show()

            }

        }

        val txt_Vaccine = findViewById<TextView>(R.id.txt_Vaccine)
        txt_Vaccine.alpha = 0f
        txt_Vaccine.animate().setDuration(1500).alpha(1f)
        txt_Vaccine.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Vaccine.text = "2. You can select the vaccine you want by hitting the spinner below."

        val spinner_Vaccine : Spinner = findViewById(R.id.spinner_Vaccine)
        ArrayAdapter.createFromResource(
            this,
                R.array.Vaccine_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_Vaccine.adapter = adapter
        }

        val btn_Selection = findViewById<Button>(R.id.btn_Selection)
        btn_Selection.setOnClickListener {

        }
    }
}