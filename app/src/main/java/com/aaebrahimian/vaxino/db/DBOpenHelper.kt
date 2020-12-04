package com.aaebrahimian.vaxino.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.activitycodes.CityAndVaccine
import com.aaebrahimian.vaxino.model.Clinic
import com.aaebrahimian.vaxino.model.Person


class DBOpenHelper(context : Context?) : SQLiteOpenHelper( context , null ,null , 1 ) {

    var cityPosition = CityAndVaccine()
    var vaccinePosition = CityAndVaccine()


    companion object{

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Vaxino.db"

        const val NAME_TABLE_CLINIC = "clinic"
        const val COLUMN_NUMBER_OF_CLINIC = "number"
        const val COLUMN_ID_CLINIC = "id"
        const val COLUMN_IMAGE_CLINIC = "img_item"
        const val COLUMN_NAME_CLINIC = "text_title"
        const val COLUMN_ADDRESS_CLINIC = "text_body"
        const val COLUMN_CITY = "city"
        const val COLUMN_VACCINE = "vaccine"


        const val NAME_TABLE_PERSON = "person"
        const val COLUMN_SSN = "ssn"
        const val COLUMN_FIRST_NAME = "firstname"
        const val COLUMN_LAST_NAME = "lastname"
        const val COLUMN_AGE = "birthday"
        const val COLUMN_ID_PERSON = "id"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_PHONE_NUMBER = "phone"

    }



    override fun onCreate (db: SQLiteDatabase?) {

        val createClinicTable = "CREATE TABLE IF NOT EXISTS $NAME_TABLE_CLINIC" +
                "($COLUMN_ID_CLINIC INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "$COLUMN_NUMBER_OF_CLINIC INTEGER , " +
                "$COLUMN_IMAGE_CLINIC IMAGE, " +
                "$COLUMN_NAME_CLINIC TEXT , " +
                "$COLUMN_ADDRESS_CLINIC TEXT, " +
                "$COLUMN_CITY INTEGER, " +
                "$COLUMN_VACCINE INTEGER)"
        db?.execSQL(createClinicTable)
        data(db)

        val createPersonTable = "CREATE TABLE IF NOT EXISTS $NAME_TABLE_PERSON " +
                "($COLUMN_SSN INTEGER, " +
                "$COLUMN_FIRST_NAME TEXT, " +
                "$COLUMN_LAST_NAME TEXT, " +
                "$COLUMN_AGE DATE, " +
                "$COLUMN_ID_PERSON INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "$COLUMN_GENDER INTEGER, " +
                "$COLUMN_PHONE_NUMBER INTEGER)"
        db?.execSQL(createPersonTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $NAME_TABLE_PERSON")
        onCreate(db)
    }

    fun getDataSetClinic(context: Context?,db: SQLiteDatabase?): ArrayList<Clinic>{
        val dataSet : ArrayList<Clinic> = ArrayList<Clinic>()

        var cursor : Cursor? =
                db?.query(NAME_TABLE_CLINIC,
                        arrayOf(COLUMN_NUMBER_OF_CLINIC,
                                COLUMN_IMAGE_CLINIC,
                                COLUMN_NAME_CLINIC,
                                COLUMN_ADDRESS_CLINIC,
                                COLUMN_CITY,
                                COLUMN_VACCINE), null, null, null, null, null)

        while (cursor!!.moveToNext()){
                var clinic = Clinic(cursor.getInt(0),cursor.getInt(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getInt(4),cursor.getInt(5)
                )
                dataSet.add(clinic)
        }
        Toast.makeText(context,"$cityPosition" ,Toast.LENGTH_LONG).show()
        Toast.makeText(context,"${cursor.count} Record Found" ,Toast.LENGTH_LONG).show()
        cursor.close()
        return dataSet

    }

    fun getDataSetPerson (context: Context?,db: SQLiteDatabase?) : ArrayList<Person>{
        val setPerson :ArrayList<Person> = ArrayList<Person>()

        var cursor : Cursor? =
                db?.query(NAME_TABLE_PERSON,
                        arrayOf( COLUMN_SSN,
                                COLUMN_FIRST_NAME,
                                COLUMN_LAST_NAME,
                                COLUMN_AGE,
                                COLUMN_ID_PERSON,
                                COLUMN_GENDER,
                                COLUMN_PHONE_NUMBER), null, null, null, null, null)

        while (cursor!!.moveToNext()){
            var person = Person(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getInt(3),
                    cursor.getShort(4),cursor.getInt(5))
            setPerson.add(person)
        }
        Toast.makeText(context,"${cursor.count} Record Found" ,Toast.LENGTH_LONG).show()
        cursor.close()
        return setPerson

    }

    fun insertClinicTable(db: SQLiteDatabase?,number : Int, image : Int, title: String, body : String, city : Int , vaccine : Int){

        val contentValues = ContentValues()
        contentValues.put(COLUMN_NUMBER_OF_CLINIC , number)
        contentValues.put(COLUMN_IMAGE_CLINIC, image)
        contentValues.put(COLUMN_NAME_CLINIC, title)
        contentValues.put(COLUMN_ADDRESS_CLINIC, body)
        contentValues.put(COLUMN_CITY, city)
        contentValues.put(COLUMN_VACCINE, vaccine)
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

    fun data(db: SQLiteDatabase?) {
        insertClinicTable(db, 0 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 1 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 2 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 3 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 4 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 5 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 6 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 7 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 8 , R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 10, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 11, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 12, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 13, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 14, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 15, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 16, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 17, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 18, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 19, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 20, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 21, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 22, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 23, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 24, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 25, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 26, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 27, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 28, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 29, R.drawable.images,"name hospital","address",1,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",1,1)
    }
}





