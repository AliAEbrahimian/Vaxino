package com.aaebrahimian.vaxino.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.model.Clinic


class DBOpenHelper(context : Context?) : SQLiteOpenHelper( context , null ,null , 1 ) {

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
        dataClinic(db)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun getDataSetClinic(context: Context?, db: SQLiteDatabase?, city: Int, vaccine: Int): ArrayList<Clinic>{
        val dataSet : ArrayList<Clinic> = ArrayList<Clinic>()

        var cursor : Cursor? =
                db?.query(NAME_TABLE_CLINIC,
                        arrayOf(COLUMN_NUMBER_OF_CLINIC,
                                COLUMN_IMAGE_CLINIC,
                                COLUMN_NAME_CLINIC,
                                COLUMN_ADDRESS_CLINIC,
                                COLUMN_CITY,
                                COLUMN_VACCINE),"$COLUMN_CITY = '$city' AND $COLUMN_VACCINE = '$vaccine'",null, null, null, null)

        while (cursor!!.moveToNext()){
                var clinic = Clinic(cursor.getInt(0),cursor.getInt(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getInt(4),cursor.getInt(5)
                )
                dataSet.add(clinic)
        }
        //Toast.makeText(context,"$cityPo" ,Toast.LENGTH_LONG).show()
        //Toast.makeText(context,"$vaccinePo" ,Toast.LENGTH_LONG).show()
        Toast.makeText(context,"${cursor.count} Record Found" ,Toast.LENGTH_LONG).show()
        cursor.close()
        return dataSet

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




    fun dataClinic(db: SQLiteDatabase?) {
        insertClinicTable(db, 32330043, R.drawable.mehregan,"بیمارستان مهرگان","شیخ بهایی",1,1)
        insertClinicTable(db, 32330043, R.drawable.mehregan,"بیمارستان مهرگان","شیخ بهایی",1,2)
        insertClinicTable(db, 32222127, R.drawable.khorshid,"بیمارستان خورشید","استانداری",1,1)
        insertClinicTable(db, 32222127, R.drawable.khorshid,"بیمارستان خورشید","استانداری",1,2)
        insertClinicTable(db, 34509901, R.drawable.gharazi,"بیمارستان قرضی","خیابان کاوه",1,1)
        insertClinicTable(db, 34509901, R.drawable.gharazi,"بیمارستان قرضی","خیابان کاوه",1,2)
        insertClinicTable(db, 37774001, R.drawable.miladesfahan,"بیمارستان میلاد","شهرک امیریه",1,1)
        insertClinicTable(db, 37774001, R.drawable.miladesfahan,"بیمارستان میلاد","شهرک امیریه",1,2)
        insertClinicTable(db, 32346338, R.drawable.beheshti,"بیمارستان شهید بهشتی","پل فلزی",1,1)
        insertClinicTable(db, 32346338, R.drawable.beheshti,"بیمارستان شهید بهشتی","پل فلزی",1,2)
        insertClinicTable(db, 32250041, R.drawable.askarie,"بیمارستان اسکریه","سروش",1,1)
        insertClinicTable(db, 32250041, R.drawable.askarie,"بیمارستان اسکریه","سروش",1,2)
        insertClinicTable(db, 36272001, R.drawable.shariati,"بیمارستان چمران","چهارباغ بالا",1,2)
        insertClinicTable(db, 32600961, R.drawable.chamran,"بیمارستان چمران","بزرگمهر",1,2)
        insertClinicTable(db, 36273031, R.drawable.sadi,"بیمارستان سعدی","نظر میانی",1,2)
        insertClinicTable(db, 84090, R.drawable.miladtehran,"بیمارستان میلاد","اتوبان همت",2,1)
        insertClinicTable(db, 84090, R.drawable.miladtehran,"بیمارستان میلاد","اتوبان همت",2,2)
        insertClinicTable(db, 88820091, R.drawable.jam,"بیمارستان جم","شهید مطهری",2,1)
        insertClinicTable(db, 88820091, R.drawable.jam,"بیمارستان جم","شهید مطهری",2,2)
        insertClinicTable(db, 88787111, R.drawable.dey,"بیمارستان دی","ولی عصر",2,1)
        insertClinicTable(db, 88787111, R.drawable.dey,"بیمارستان دی","ولی عصر",2,2)
        insertClinicTable(db, 38241, R.drawable.fajr,"بیمارستان فجر","پیروزی",2,1)
        insertClinicTable(db, 38241, R.drawable.fajr,"بیمارستان فجر","پیروزی",2,2)
        insertClinicTable(db, 55630213, R.drawable.razi,"بیمارستان راضی","وحدت",2,2)
        insertClinicTable(db, 88751477, R.drawable.madaran,"بیمارستان مادران","میدان تختی",2,2)
        insertClinicTable(db, 63120, R.drawable.sinatehran,"بیمارستان سینا","امام خمینی",2,1)
        insertClinicTable(db, 22824011, R.drawable.images,"بیمارستان نور افشار","نیاوران",2,2)
        insertClinicTable(db, 23021000, R.drawable.erfan,"بیمارستان عرفان","سعادت اباد",2,2)
        insertClinicTable(db, 33542000, R.drawable.images,"بیمارستان یهیایی","مجاهدین",2,2)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,2)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,2)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,2)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,2)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
        insertClinicTable(db, 30, R.drawable.images,"name hospital","address",3,1)
    }
}





