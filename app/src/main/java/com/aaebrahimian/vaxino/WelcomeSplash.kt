package com.aaebrahimian.vaxino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlin.concurrent.timerTask

class WelcomeSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_splash)
        val img_Welcome_Splash = findViewById<ImageView>(R.id.img_Welcome_Splash)

        img_Welcome_Splash.alpha = 0f
        img_Welcome_Splash.animate().setDuration(4000).alpha(1f).withEndAction{
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
         }

    }
}