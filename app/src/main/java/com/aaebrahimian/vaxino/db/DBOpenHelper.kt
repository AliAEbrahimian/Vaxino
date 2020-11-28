package com.aaebrahimian.vaxino.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.aaebrahimian.vaxino.model.Models

class DBOpenHelper(context : Context?) :
        SQLiteOpenHelper( context , null ,null ,1 ) {


    companion object{
         const val DATABASE_VERSION = 1
         const val DATABASE_NAME = "Vaxino.db"

         const val NAME_TABLE_CLINIC = "clinic"
         const val COLUMN_NUMBER_OF_CLINIC = "id"
         const val COLUMN_NAME_CLINIC = "text_title"
         const val COLUMN_ADDRESS_CLINIC = "text_body"
         const val COLUMN_IMAGE_CLINIC = "img_item"

         const val NAME_TABLE_PERSON = "person"
         const val COLUMN_FIRST_NAME = "firstname"
         const val COLUMN_LAST_NAME = "lastname"
         const val COLUMN_BIRTH_DAY = "birthday"
         const val COLUMN_ID = "id"
         const val COLUMN_GENDER = "gender"
         const val COLUMN_PHONE_NUMBER = "phone"
    }



    override fun onCreate(db: SQLiteDatabase?) {

         val createClinicTable = "CREATE TABLE $NAME_TABLE_CLINIC($COLUMN_NUMBER_OF_CLINIC INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, $COLUMN_NAME_CLINIC TEXT , $COLUMN_ADDRESS_CLINIC TEXT , $COLUMN_IMAGE_CLINIC IMAGE)"
        db?.execSQL(createClinicTable)

        val createPersonTable = "CREATE TABLE $NAME_TABLE_PERSON ($COLUMN_FIRST_NAME TEXT, $COLUMN_LAST_NAME TEXT,$COLUMN_BIRTH_DAY DATE,$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, $COLUMN_GENDER, BIT$COLUMN_PHONE_NUMBER NUMBER)"
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
                val models = Models()
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