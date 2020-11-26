package com.aaebrahimian.vaxino.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.activitycodes.MainActivity

class WelcomeSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_splash)
        val img_Welcome_Splash = findViewById<ImageView>(R.id.img_Welcome_Splash)
        val txt_Vaxino = findViewById<TextView>(R.id.txt_vaxino)

        txt_Vaxino.text = "VAXINO"
        txt_Vaxino.typeface = ResourcesCompat.getFont(this, R.font.pdark)

        img_Welcome_Splash.alpha = 0f
        txt_Vaxino.alpha = 0f

        img_Welcome_Splash.animate().setDuration(3000).alpha(1f)
        txt_Vaxino.animate().setDuration(3000).alpha(1f).withEndAction{

            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
         }

    }
}