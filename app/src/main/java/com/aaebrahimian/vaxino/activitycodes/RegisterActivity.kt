package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nested_Register.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))

        edtxt_first_name.hint = "First Name"
        edtxt_last_name.hint="Last Name"
        edtxt_ssn.hint = "(Social Security Number) Example: 1234567890"
        edtxt_age.hint = "(Age) Example: 18"
        edtxt_phone_number.hint = "(Phone) Example: 09123456789"


        /*btn_Save.isEnabled = when{
            edtxt_first_name.text.trim().toString().isEmpty() -> false
            edtxt_last_name.text.trim().toString().isEmpty()-> false
            edtxt_ssn.text.trim().toString().isEmpty() -> false
            edtxt_age.text.trim().toString().isEmpty() -> false
            edtxt_phone_number.text.trim().toString().isEmpty() -> false
            else -> true
        }*/

        val firstName = edtxt_first_name.text
        val lastName = edtxt_last_name.text
        val ssn = edtxt_ssn.text
        val age = edtxt_age.text
        val phone = edtxt_phone_number.text

        var sex = 0
        fun onRadioButtonClicked(view: View) {
            if (view is RadioButton) {
                // Is the button now checked?
                val checked = view.isChecked

                // Check which radio button was clicked
                when (view.getId()) {
                    R.id.radio_female ->
                        if (checked) {
                            sex = 1
                        }
                    R.id.radio_male ->
                        if (checked) {
                            sex = 2
                        }
                }
            }
        }

        val gender = when(sex){ 1 -> "male"; 2 -> "female"; else -> "ERROR"}

        txt_Register.alpha = 0f
        txt_Register.animate().setDuration(1500).alpha(1f)
        txt_Register.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Register.text = "Fill in the blanks.\n" +
                "All the required items are needed to go to the next step."


        btn_Save.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Save.setOnClickListener {



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

            Toast.makeText(this, "$firstName/$lastName/$ssn/$age/$phone/$sex", Toast.LENGTH_SHORT).show()

        /*val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        */
        }

    }
}