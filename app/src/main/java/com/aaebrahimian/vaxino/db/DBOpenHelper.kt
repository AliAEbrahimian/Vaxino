package com.aaebrahimian.vaxino.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context?) : SQLiteOpenHelper( context ,null ,null ,1 ) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE 'vaxino'(id INTEGER AUTOINCREMENT PRIMARY KEY NOT NULL , text_title TEXT , text_body TEXT , img_item )")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}