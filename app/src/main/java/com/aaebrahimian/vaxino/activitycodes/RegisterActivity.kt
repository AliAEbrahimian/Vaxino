package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nested_Register.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))

        edtxt_First_Name.setHint("First Name")
        edtxt_Last_Name.setHint("Last Name")
        edtxt_SSN.setHint("(Social Security Number) Example: 1234567890")
        edtxt_Age.setHint("(Age) Example: 18")
        ednum_Phone_Number.setHint("(Phone) Example: 09123456789")

        val firstName = edtxt_First_Name.text.toString()
        val lastName = edtxt_Last_Name.text.toString()
        val ssn = edtxt_SSN.text.toString()
        val age = edtxt_SSN.text.toString()
        val phone = ednum_Phone_Number.text.toString()

        txt_Register.alpha = 0f
        txt_Register.animate().setDuration(1500).alpha(1f)
        txt_Register.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Register.text = "a"

        edtxt_First_Name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(firstName != null)
                    btn_Save.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        edtxt_Last_Name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(lastName != null)
                    btn_Save.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        edtxt_SSN.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(ssn != null)
                    btn_Save.isEnabled = true
            }
            override fun afterTextChanged(s: Editable?) {
            }

        })
        edtxt_Age.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(age != null)
                    btn_Save.isEnabled = true
            }
            override fun afterTextChanged(s: Editable?) {
            }

        })

        ednum_Phone_Number.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(phone != null)
                    btn_Save.isEnabled = true
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })




        btn_Save.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Save.setOnClickListener {
            btn_Save.animate().apply {
                duration = 1000
                rotationXBy(360f)
                rotationYBy(360f)
            }.withEndAction() {
                val intent = Intent(this, ConfirmedActivity::class.java)

                intent.putExtra("key_1",firstName)
                intent.putExtra("key_2",lastName)
                intent.putExtra("key_3",ssn)
                intent.putExtra("key_4",age)
                intent.putExtra("key_5",phone)
                var gender = 100
                if(radio_Male.isChecked) {
                    gender = 1
                    intent.putExtra("key_6", gender)
                }
                else if(radio_Female.isChecked) {
                    gender = 0
                    intent.putExtra("key_6",gender)
                }
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            }
        }

        btn_Cancel.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Cancel.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        }

    }
}