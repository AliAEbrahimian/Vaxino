package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.db.DBOpenHelper
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var editText :EditText
    lateinit var radioGroup : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        edtxt_First_Name.setHint("First Name")
        edtxt_Last_Name.setHint("Last Name")
        edtxt_SSN.setHint("(Social Security Number) Example: 1234567890")
        edtxt_Age.setHint("(Age) Example: 18")
        ednum_Phone_Number.setHint("(Phone) Example: 09123456789")

        txt_Register.alpha = 0f
        txt_Register.animate().setDuration(1500).alpha(1f)
        txt_Register.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Register.text = "a"

        var dbOpenHelper = DBOpenHelper(this)
        fun submit(view: View) {
            editText = edtxt_First_Name as EditText

            editText = edtxt_Last_Name as EditText

            editText = edtxt_SSN as EditText

            editText = edtxt_Age as EditText

            editText = ednum_Phone_Number as EditText

            radioGroup = radio_Gender as RadioGroup



        }
        btn_Save.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Save.setOnClickListener {
            btn_Save.animate().apply {
                duration = 1000
                rotationXBy(360f)
                rotationYBy(360f)
            }.withEndAction() {
                val intent = Intent(this, ConfirmedActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            }
        }
        btn_Cancel.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Cancel.setOnClickListener {
            btn_Cancel.animate().apply {
                duration = 1000
                rotationXBy(360f)
                rotationYBy(360f)
            }.withEndAction() {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
                onRestart()
            }
        }

    }
}