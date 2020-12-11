package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_confirmed.*

class ConfirmedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed)

        nested_Confirmed.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))

        val firstName: String = intent.getStringExtra("firstName").toString()
        val lastName: String = intent.getStringExtra("lastName").toString()
        val ssn: String = intent.getStringExtra("SSN").toString()
        val age: String = intent.getStringExtra("age").toString()
        val phone: String = intent.getStringExtra("phone").toString()
        val valueGender = intent.getStringExtra("gender").toString()

        Toast.makeText(this, "$firstName/$lastName/$ssn/$age/$phone/$valueGender",Toast.LENGTH_SHORT).show()

        txt_confirmed.text = "Information registered in the registration section\n" +
                "First name: ${firstName.capitalize()} \n" +
                "Last name: ${lastName.capitalize()} \n" +
                "SSN: $ssn \n" +
                "Gender: ${valueGender.capitalize()} \n" +
                "Age: $age \n" +
                "Phone Number: $phone"

        btn_Confirmed.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Confirmed.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            Toast.makeText(this, "All your information has been registered.\n" +
                    " More information will be sent to you via SMS.", Toast.LENGTH_LONG).show()
        }
    }
}