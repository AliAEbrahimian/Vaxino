package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_Main.alpha = 0f
        txt_Main.animate().setDuration(1500).alpha(1f)
        txt_Main.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Main.text = "Description:\n" +
                "1. By pressing the START VACCINE button you will enter the vaccination stage\n" +
                "2. By pressing the SEARCH button you will recover your data"

        btn_Start_Vaccine.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Start_Vaccine.setOnClickListener {
            val intent = Intent (this, SelectActivity::class.java)
            startActivity(intent)
        }

        btn_Follow_Up.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Follow_Up.setOnClickListener {

        }
    }
}
