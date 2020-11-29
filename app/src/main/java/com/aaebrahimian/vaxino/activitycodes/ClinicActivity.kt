package com.aaebrahimian.vaxino.activitycodes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.db.DBOpenHelper
import com.aaebrahimian.vaxino.recyclerview.RecViewArrayAdapted
import kotlinx.android.synthetic.main.activity_clinic.*

class ClinicActivity : AppCompatActivity() {

    var dbOpenHelper = DBOpenHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)

        val list = dbOpenHelper.getDataSetClinic(this,dbOpenHelper.readableDatabase)
        val adapter = RecViewArrayAdapted(this,list)
        clinic_RecyclerView.adapter = adapter
        clinic_RecyclerView.layoutManager = LinearLayoutManager(this)

        dbOpenHelper.close()

        //viewDataSet()

    }

}
