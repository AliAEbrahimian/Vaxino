package com.aaebrahimian.vaxino.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.aaebrahimian.vaxino.activitycodes.ClinicActivity
import com.aaebrahimian.vaxino.model.Clinic
import com.aaebrahimian.vaxino.model.Person


class DBOpenHelper(context : Context?) : SQLiteOpenHelper( context , null ,null , 1 ) {

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Vaxino.db"

        const val NAME_TABLE_CLINIC = "clinic"
        const val COLUMN_NUMBER_OF_CLINIC = "id"
        const val COLUMN_NAME_CLINIC = "text_title"
        const val COLUMN_ADDRESS_CLINIC = "text_body"
        const val COLUMN_IMAGE_CLINIC = "img_item"

        const val NAME_TABLE_PERSON = "person"
        const val COLUMN_SSN = "ssn"
        const val COLUMN_FIRST_NAME = "firstname"
        const val COLUMN_LAST_NAME = "lastname"
        const val COLUMN_AGE = "birthday"
        const val COLUMN_ID = "id"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_PHONE_NUMBER = "phone"

    }



    override fun onCreate(db: SQLiteDatabase?) {

        val createClinicTable = "CREATE TABLE $NAME_TABLE_CLINIC($COLUMN_NUMBER_OF_CLINIC INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, $COLUMN_NAME_CLINIC TEXT , $COLUMN_ADDRESS_CLINIC TEXT , $COLUMN_IMAGE_CLINIC IMAGE)"
        db?.execSQL(createClinicTable)

        val createPersonTable = "CREATE TABLE $NAME_TABLE_PERSON ($COLUMN_SSN INTEGER,$COLUMN_FIRST_NAME TEXT,$COLUMN_LAST_NAME TEXT,$COLUMN_AGE DATE,$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, $COLUMN_GENDER INTEGER,$COLUMN_PHONE_NUMBER INTEGER)"
        db?.execSQL(createPersonTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $NAME_TABLE_PERSON")
        onCreate(db)
    }

    fun getDataSetClinic(db: SQLiteDatabase?): ArrayList<Clinic>{
        val dataSet : ArrayList<Clinic> = ArrayList<Clinic>()
        
        var cursor : Cursor? =
                db?.query(NAME_TABLE_CLINIC, arrayOf( COLUMN_IMAGE_CLINIC, COLUMN_NAME_CLINIC, COLUMN_ADDRESS_CLINIC), null, null, null, null, null)

        while (cursor!!.moveToNext()){
                var clinic = Clinic(cursor.getInt(0), cursor.getString(1), cursor.getString(2))
                dataSet.add(clinic)
        }
        cursor.close()
        return dataSet

    }

    fun getDataSetPerson (db: SQLiteDatabase?) : ArrayList<Person>{
        val setPerson :ArrayList<Person> = ArrayList<Person>()

        var cursor : Cursor? =
                db?.query(NAME_TABLE_PERSON, arrayOf( COLUMN_SSN, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_AGE, COLUMN_ID, COLUMN_GENDER, COLUMN_PHONE_NUMBER), null, null, null, null, null)

        while (cursor!!.moveToNext()){
            var person = Person(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getShort(4),cursor.getInt(5))
            setPerson.add(person)
        }
        cursor.close()
        return setPerson

    }

    fun insertClinicTable(db: SQLiteDatabase?, image : Int, title: String, body : String){

        val contentValues = ContentValues()
        contentValues.put(COLUMN_IMAGE_CLINIC, image)
        contentValues.put(COLUMN_NAME_CLINIC, title)
        contentValues.put(COLUMN_ADDRESS_CLINIC, body)

        db?.insert(NAME_TABLE_CLINIC, null, contentValues)
    }
    fun insertPersonTable(db: SQLiteDatabase?,personId: Int , firstname: String,  lastname: String,  age: Int,  gender: Boolean,  phone: Int){

        val contentValues = ContentValues()
        contentValues.put(COLUMN_SSN,personId)
        contentValues.put(COLUMN_FIRST_NAME,firstname)
        contentValues.put(COLUMN_LAST_NAME,lastname)
        contentValues.put(COLUMN_AGE, age)
        contentValues.put(COLUMN_GENDER,gender)
        contentValues.put(COLUMN_PHONE_NUMBER,phone)
        db?.insert(NAME_TABLE_PERSON, null, contentValues)
    }



}

