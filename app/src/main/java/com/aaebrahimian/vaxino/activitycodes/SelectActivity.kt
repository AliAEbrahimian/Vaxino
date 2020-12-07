package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.resources.Statics
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_select.*


class SelectActivity : AppCompatActivity() {

    val statics:Statics = Statics()
    var vaccine = ""
    var city = ""
    var cityPosition = 0
    var vaccinePosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)


        txt_City.alpha = 0f
        txt_City.animate().setDuration(1500).alpha(1f)
        txt_City.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_City.text = "1. You can select your desired city by hitting the spinner below."
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
                statics.cityList.get(position).also { cityPosition = position }
                city = statics.cityList[cityPosition]
                //Toast.makeText(this@SelectActivity, "You select ${statics.cityList[position]}", Toast.LENGTH_SHORT).show()
                //Toast.makeText(this@CityAndVaccine,"position" + cityPosition ,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText( this@SelectActivity, "You not select item" , Toast.LENGTH_SHORT).show()

            }

        }


        txt_Vaccine.alpha = 0f
        txt_Vaccine.animate().setDuration(1500).alpha(1f)
        txt_Vaccine.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Vaccine.text = "2. You can select the vaccine you want by hitting the spinner below."
        ArrayAdapter.createFromResource(
            this,
                R.array.Vaccine_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_Vaccine.adapter = adapter
        }
        spinner_Vaccine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                statics.vaccineList.get(position).also { vaccinePosition = position }
                vaccine = statics.vaccineList[vaccinePosition]
                //Toast.makeText(this@SelectActivity, "You select ${statics.vaccineList[position]}", Toast.LENGTH_SHORT).show()
                //Toast.makeText(this@CityAndVaccine,"position" + vaccinePosition ,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        btn_Selection.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Selection.setOnClickListener {
            if( this.cityPosition === 0 && this.vaccinePosition === 0) {
                Toast.makeText( this@SelectActivity, "You not select city and vaccine" , Toast.LENGTH_SHORT).show()
            }
            else if(cityPosition === 0){
                Toast.makeText( this@SelectActivity, "You not select city" , Toast.LENGTH_SHORT).show()
            }
            else if(vaccinePosition === 0){
                Toast.makeText( this@SelectActivity, "You not select vaccine" , Toast.LENGTH_SHORT).show()
            }
            else{
                btn_Selection.animate().apply {
                    duration = 1000
                    rotationXBy(360f)
                    rotationYBy(360f)
                }.withEndAction() {
                    Toast.makeText( this@SelectActivity, "You select items, ${city} * ${vaccine}" , Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ClinicActivity::class.java)
                    intent.putExtra("key_1",cityPosition)
                    intent.putExtra("key_2",vaccinePosition)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
                }
            }


        }
    }
}