package com.aaebrahimian.vaxino

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img_Main = findViewById<ImageView>(R.id.img_Main)

        val btn_Start_Vaccine = findViewById<Button>(R.id.btn_Start_Vaccine)
        val btn_Follow_Up = findViewById<Button>(R.id.btn_Follow_Up)
        val txt_Main = findViewById<TextView>(R.id.txt_Main)

        txt_Main.typeface = ResourcesCompat.getFont(this,R.font.aldhabi)
        txt_Main.text = "\n"+"راهنمای شروع\n" + "با فشار دادن دکمه شروع انتخاب واکسن " +
                "وارد مرحله انتخاب شهر خود خواهید شد.\n" +
                    "با فشار دادن دکمه جستوجو میتوانید اطلاعات خود را بیابید."

        btn_Start_Vaccine.typeface = ResourcesCompat.getFont(this,R.font.aldhabi)
        btn_Start_Vaccine.setOnClickListener {
            val intent = Intent (this, CityActivity::class.java)
            startActivity(intent)
        }

        btn_Follow_Up.typeface = ResourcesCompat.getFont(this,R.font.aldhabi)
        btn_Follow_Up.setOnClickListener {

        }
    }
}
