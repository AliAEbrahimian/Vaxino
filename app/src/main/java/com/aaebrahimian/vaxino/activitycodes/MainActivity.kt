package com.aaebrahimian.vaxino.activitycodes

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nested_Mian.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))
        img_Main.startAnimation(AnimationUtils.loadAnimation(this,R.anim.photo_animation))
        img_Main.setBackgroundResource(R.drawable.main)

        txt_Main.alpha = 0f
        txt_Main.animate().setDuration(1500).alpha(1f)
        txt_Main.typeface = ResourcesCompat.getFont(this, R.font.frission)
        txt_Main.text = "Description:\n" +
                "1. By pressing the START VACCINE button you will enter the vaccination stage\n" +
                "2. By pressing the SEARCH button you will recover your data"

        btn_Start_Vaccine.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Start_Vaccine.setOnClickListener {
                val intent = Intent(this, SelectActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        }
        btn_Follow_Up.typeface = ResourcesCompat.getFont(this, R.font.frission)
        btn_Follow_Up.setOnClickListener {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        }
    }
}
