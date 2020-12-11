package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    var sex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        nested_Register.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))

        edtxt_first_name.hint = "First Name"
        edtxt_last_name.hint="Last Name"
        edtxt_ssn.hint = "(Social Security Number) Example: 1234567890"
        edtxt_age.hint = "(Age) Example: 18"
        edtxt_phone_number.hint = "(Phone) Example: 09123456789"

        val firstName = edtxt_first_name.text
        val lastName = edtxt_last_name.text
        val ssn = edtxt_ssn.text
        val age = edtxt_age.text
        val phone = edtxt_phone_number.text

        txt_Register.alpha = 0f
        txt_Register.animate().setDuration(1500).alpha(1f)
        txt_Register.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Register.text = "Fill in the blanks.\n" +
                "All the required items are needed to go to the next step."


        btn_Save.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Save.setOnClickListener {


            var gender = when(sex){ 1 -> "female"; 2 -> "male"; else -> "ERROR"}

            val intent = Intent(this, ConfirmedActivity::class.java)
            intent.putExtra("firstName","$firstName")
            intent.putExtra("lastName","$lastName")
            intent.putExtra("SSN","$ssn")
            intent.putExtra("age","$age")
            intent.putExtra("phone","$phone")
            intent.putExtra("gender","$gender")
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)

        }

        btn_Cancel.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Cancel.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)

        }

    }


    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_female ->
                    if (checked) {
                        sex = 1
                        Log.d("radio button", "female")
                        Log.d("radio button", sex.toString())
                    }
                R.id.radio_male ->
                    if (checked) {
                        sex = 2
                        Log.d("radio button", "male")
                        Log.d("radio button", sex.toString())
                    }
            }
        }
    }
}