package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.db.DBOpenHelper
import com.aaebrahimian.vaxino.model.Clinic
import kotlinx.android.synthetic.main.activity_information_clinic.*

class InformationClinicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_clinic)

        var detailsClinic = intent.getParcelableExtra<Clinic>("key_1")

        var dbOpenHelper = DBOpenHelper(this)

        var list = dbOpenHelper.getClinicInformation(this, dbOpenHelper.readableDatabase,"Mehregan Hospital")

        txt_Information_Clinic.alpha = 0f
        txt_Information_Clinic.animate().setDuration(1500).alpha(1f)
        txt_Information_Clinic.typeface = ResourcesCompat.getFont(this, R.font.frission)

        txt_Information_Clinic.text = "Hospital Name: (x)\n" +
                "Has a vaccine (x) for a limited number.\n" +
                "Hospital address: (x) city, street (x)\n" +
                "Contact number: (x)\n"


        btn_Call.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Call.setOnClickListener {
        }

        btn_Selection.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Selection.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}
