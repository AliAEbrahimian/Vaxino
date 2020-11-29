package com.aaebrahimian.vaxino.activitycodes

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.db.DBOpenHelper
import com.aaebrahimian.vaxino.recyclerview.PostsAdapter
import kotlinx.android.synthetic.main.activity_clinic.*

class ClinicActivity : AppCompatActivity() {

    companion object{
        lateinit var dbOpenHelper : DBOpenHelper
        lateinit var insertclinictable : DBOpenHelper
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)
        dbOpenHelper = DBOpenHelper(this)

        val list = dbOpenHelper.getDataSetClinic(dbOpenHelper.readableDatabase)
        val adapter = PostsAdapter(this,list)
        clinic_RecyclerView.adapter = adapter
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
