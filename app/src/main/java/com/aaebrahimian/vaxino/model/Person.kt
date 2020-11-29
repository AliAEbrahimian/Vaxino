package com.aaebrahimian.vaxino.model

import android.os.Parcel
import android.os.Parcelable

class Person(var personId: Int, var firstname: String?, var lastname: String?, var age: Int, var gender: Short, var phone: Int): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt().toShort(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(personId)
        parcel.writeString(firstname)
        parcel.writeString(lastname)
        parcel.writeInt(age)
        parcel.writeInt(gender.toInt())
        parcel.writeInt(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }

}