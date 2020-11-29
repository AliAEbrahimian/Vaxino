package com.aaebrahimian.vaxino.activitycodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val list = dbOpenHelper.getDataSetClinic(dbOpenHelper.readableDatabase)

        val adapter = RecViewArrayAdapted(this,list)
        clinic_RecyclerView.adapter = adapter
        clinic_RecyclerView.layoutManager = LinearLayoutManager(this)

        dbOpenHelper.close()

        //viewDataSet()

    }

    private fun  viewDataSet (){

        /*insertclinictable.insertClinicTable(,)

        dbOpenHelper = DBOpenHelper(this)
        val list = Companion.dbopenHelper.getDataSetClinic(dbopenHelper)
        clinic_RecyclerView.adapter = adapter

        //val list = dbopenHelper.getDataSetClinic(this)
        //val adapter = PostsAdapter(this, list)
        //clinic_RecyclerView.adapter = adapter*/
    }
}
