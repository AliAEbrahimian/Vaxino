package com.aaebrahimian.vaxino.model

import android.os.Parcel
import android.os.Parcelable

class Clinic(var number: Int ,var image: Int, var title: String?, var body: String?, var city: Int, var vaccine: Int): Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(body)
        parcel.writeInt(city)
        parcel.writeInt(vaccine)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Clinic> {
        override fun createFromParcel(parcel: Parcel): Clinic {
            return Clinic(parcel)
        }

        override fun newArray(size: Int): Array<Clinic?> {
            return arrayOfNulls(size)
        }
    }

}