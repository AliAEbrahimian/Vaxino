package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_confirmed.*

class ConfirmedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed)

        var firsName = intent.getStringExtra("Key_1")
        var lastName = intent.getStringExtra("key_2")
        var ssn = intent.getStringExtra("key_3")
        var age = intent.getStringExtra("key_4")
        var phone = intent.getStringExtra("key_5")
        var gender = intent.getIntExtra("key_6",0)

        var valueGender = ""

        if(gender === 1)
            valueGender = "Male"
        else if(gender === 0)
            valueGender = "Female"

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