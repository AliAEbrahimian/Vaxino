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

        nested_informationClinic.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))
        var clinic = intent.getParcelableExtra<Clinic>("Clinic")

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
            txt_Information_Clinic.text = "Hospital Name: '${clinic.title}\n'" +
                    "Has a vaccine ${stringOfVaccine}" +
                    " for a limited number.\n" +
                    "Hospital address: ${stringOfCity}" +
                    ",${clinic.body}\n street" +
                    "Contact number: ${clinic.number}\n"
        }


        btn_Selection.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Selection.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)

        }


    }
}
