package com.aaebrahimian.vaxino.activitycodes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txt_Register.alpha = 0f
        txt_Register.animate().setDuration(1500).alpha(1f)
        txt_Register.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Register.text = "a"

        btn_Save.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Save.setOnClickListener {

        }
        btn_Cancel.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Cancel.setOnClickListener {

        }

    }
}