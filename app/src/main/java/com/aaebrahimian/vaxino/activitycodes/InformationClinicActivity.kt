package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.model.Clinic
import kotlinx.android.synthetic.main.activity_information_clinic.*

class InformationClinicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_clinic)

        var clinic = intent.getParcelableExtra<Clinic>("key_1")

        txt_Information_Clinic.alpha = 0f
        txt_Information_Clinic.animate().setDuration(1500).alpha(1f)
        txt_Information_Clinic.typeface = ResourcesCompat.getFont(this, R.font.frission)

        if (clinic != null){
        var stringOfCity = when(clinic.city){
            0 -> "not selected"
            1 -> "isfahan"
            2 -> "tehran"
            3 -> "mashhad"
            else -> "ERROR"
        }
        var stringOfVaccine = when(clinic.vaccine){
            0 -> "not selected"
            1 -> "Covid-19"
            2 -> "Influenza"
            else -> "ERROR"
        }

            img_Clinic.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))

            img_Clinic.setImageResource(clinic.image)
            txt_Information_Clinic.text = "Hospital Name: ${clinic.title}\n" +
                    "Has a vaccine ${stringOfVaccine}" +
                    " for a limited number.\n" +
                    "Hospital address: ${stringOfCity}" +
                    " city, street ${clinic.body}\n" +
                    "Contact number: ${clinic.number}\n"
        }

        btn_Call.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Call.setOnClickListener {
            btn_Call.animate().apply {
                duration = 1000
                rotationXBy(360f)
                rotationYBy(360f)
            }.withEndAction() {
            }
        }

        btn_Selection.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Selection.setOnClickListener {
            btn_Selection.animate().apply {
                duration = 1000
                rotationXBy(360f)
                rotationYBy(360f)
            }.withEndAction() {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            }
        }


    }
}
