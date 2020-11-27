package com.aaebrahimian.vaxino.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context?, string: String , sqLiteDatabase: SQLiteDatabase.CursorFactory,version: Int ) :
        SQLiteOpenHelper( context ,null ,null ,1 ) {

    companion object{
        val nametable = "clinicTable"
        val numberOfClinic = "id"
        val nameOfclinic = "text_title"
        val addressClinic = "text_body"
        val imageOfClinic = "img_item"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable : String = ("CREATE TABLE ${nametable}" +
                "(${numberOfClinic} INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " ${nameOfclinic} TEXT ," +
                " ${addressClinic} TEXT ," +
                " ${imageOfClinic} IMAGE )")
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}