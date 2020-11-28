package com.aaebrahimian.vaxino.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Insets.add
import android.provider.BaseColumns
import android.widget.Toast
import com.aaebrahimian.vaxino.model.Models

class DBOpenHelper(context : Context,name : String? ,factory: SQLiteDatabase.CursorFactory? , version : Int) :
        SQLiteOpenHelper( context , DATABASE_NAME ,null ,DATABASE_VERSION ) {


    companion object{
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Vaxino.db"

        val NAME_TABLE_CLINIC = "clinic"
        val COLUMN_NUMBER_OF_CLINIC = "id"
        val COLUMN_NAME_CLINIC = "text_title"
        val COLUMN_ADDRESS_CLINIC = "text_body"
        val COLUMN_IMAGE_CLINIC = "img_item"

        val NAME_TABLE_PERSON = "person"
        val COLUMN_FIRST_NAME = "firstname"
        val COLUMN_LAST_NAME = "lastname"
        val COLUMN_BIRTH_DAY = "birthday"
        val _ID = "id"
        val COLUMN_GENDER = "gender"
        val COLUMN_PHONE_NUMBER = "phone"
    }



    override fun onCreate(db: SQLiteDatabase?) {

         val CREATE_CLINIC_TABLE = "CREATE TABLE $NAME_TABLE_CLINIC" +
                "($COLUMN_NUMBER_OF_CLINIC INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "$COLUMN_NAME_CLINIC TEXT ," +
                "$COLUMN_ADDRESS_CLINIC TEXT ," +
                "$COLUMN_IMAGE_CLINIC IMAGE )"
        db?.execSQL(CREATE_CLINIC_TABLE)

        val createPersonTable : String = ("CREATE TABLE $NAME_TABLE_PERSON" +
                "($COLUMN_FIRST_NAME TEXT, " +
                "$COLUMN_LAST_NAME TEXT," +
                "$COLUMN_BIRTH_DAY DATE," +
                "$_ID STRING ,"+
                "$COLUMN_GENDER BIT,"+
                "$COLUMN_PHONE_NUMBER TEXT")
        db?.execSQL(createPersonTable)



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun getDataSet (mCtx: Context) : ArrayList<Models>{
        val qry = "SELECT * FROM $NAME_TABLE_CLINIC"
        val db = this.readableDatabase
        val cursor = db.rawQuery(qry,null)
        val dataSet = ArrayList<Models>()

        if(cursor.count == 0)
            Toast.makeText(mCtx, "No records found",Toast.LENGTH_LONG).show()
        else{
            while (cursor.moveToNext()){
                var models = Models()
                models.id = cursor.getInt(cursor.getColumnIndex(COLUMN_NUMBER_OF_CLINIC))
                models.nameclinic = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_CLINIC))
                models.address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS_CLINIC))
                dataSet.add(models)
            }
            Toast.makeText(mCtx, "${cursor.count.toString()} records found",Toast.LENGTH_LONG).show()
        }
        cursor.close()
        db.close()
        return dataSet

    }

}