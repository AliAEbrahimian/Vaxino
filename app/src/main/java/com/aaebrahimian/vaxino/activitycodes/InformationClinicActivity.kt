package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_information_clinic.*

class InformationClinicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_clinic)

        txt_Information_Clinic.alpha = 0f
        txt_Information_Clinic.animate().setDuration(1500).alpha(1f)
        txt_Information_Clinic.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Information_Clinic.text = "0000"

        btn_Call.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Call.setOnClickListener {
        }

        btn_Selection.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Selection.setOnClickListener {
            val intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}