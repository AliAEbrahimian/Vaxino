package com.aaebrahimian.vaxino.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.activitycodes.MainActivity
import kotlinx.android.synthetic.main.activity_welcome_splash.*

class WelcomeSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_splash)

        txt_vaxino.text = "VAXINO"
        txt_vaxino.typeface = ResourcesCompat.getFont(this, R.font.pdark)

        img_Welcome_Splash.alpha = 0f
        txt_vaxino.alpha = 0f

        img_Welcome_Splash.animate().setDuration(2000).alpha(1f)
        txt_vaxino.animate().setDuration(2000).alpha(1f).withEndAction{

            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
         }

    }
}