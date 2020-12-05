package com.aaebrahimian.vaxino.activitycodes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.db.DBOpenHelper
import com.aaebrahimian.vaxino.recyclerview.RecViewArrayAdapted
import kotlinx.android.synthetic.main.activity_clinic.*

class ClinicActivity : AppCompatActivity() {

    companion object{
        val cityPosition = "key_1"
        val vaccinePosition = "key_2"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)

        var cityPo: Int = intent.getIntExtra(cityPosition,0)
        var vaccinePo: Int = intent.getIntExtra(vaccinePosition,0)

        var dbOpenHelper = DBOpenHelper(this)
        //Toast.makeText(this,"Number of city is $cityPo" , Toast.LENGTH_LONG).show()
        //Toast.makeText(this,"Number of vaccine is $vaccinePo" , Toast.LENGTH_LONG).show()

        val list = dbOpenHelper.getDataSetClinic(this, dbOpenHelper.readableDatabase, cityPo, vaccinePo)
        val adapter = RecViewArrayAdapted(this,list)
        clinic_RecyclerView.adapter = adapter
        clinic_RecyclerView.layoutManager = LinearLayoutManager(this)

        dbOpenHelper.close()

        //viewDataSet()

    }

}
