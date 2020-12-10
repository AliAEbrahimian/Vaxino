package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_confirmed.*

class ConfirmedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed)

        nested_Confirmed.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))

        val firsName: String? = intent.getStringExtra("Key_1")
        val lastName: String? = intent.getStringExtra("key_2")
        val ssn: String? = intent.getStringExtra("key_3")
        val age: String? = intent.getStringExtra("key_4")
        val phone: String? = intent.getStringExtra("key_5")
        val gender: String? = intent.getStringExtra("key_6")
        var valueGender = ""


        txt_confirmed.text = "Information registered in the registration section\n" +
                "First name: $firsName\n" +
                "Last name: $lastName\n" +
                "SSN: $ssn\n" +
                "Gender: $valueGender\n" +
                "Age: $age\n" +
                "Phone Number: $phone$"

        btn_Back.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}