package com.aaebrahimian.vaxino.model

import android.os.Parcel
import android.os.Parcelable

class Clinic(var image: Int, var title: String?, var body: String?): Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(body)
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