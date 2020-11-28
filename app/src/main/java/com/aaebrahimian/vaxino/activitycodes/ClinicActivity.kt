package com.aaebrahimian.vaxino.activitycodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.db.DBOpenHelper
import com.aaebrahimian.vaxino.recyclerview.PostsAdapter
import kotlinx.android.synthetic.main.activity_clinic.*

class ClinicActivity : AppCompatActivity() {

    companion object{
        lateinit var dbopenHelper : DBOpenHelper
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)

        dbopenHelper = DBOpenHelper(this)
        viewDataSet()
    }

    private fun  viewDataSet (){
        val list = dbopenHelper.getDataSet(this)
        val adapter = PostsAdapter(this, list)
        clinic_RecyclerView.adapter = adapter
        }
}
