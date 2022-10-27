package com.example.exercise2

import android.os.Parcel
import android.os.Parcelable

class ParcelableData : Parcelable {
    var name: String? = null
    var age: Int = 0
    var address: String? = null

    constructor(name: String, age: Int, address: String) {
        this.name = name
        this.age = age
        this.address = address
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        age = `in`.readInt()
        address = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
        dest.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ParcelableData> = object : Parcelable.Creator<ParcelableData> {
            override fun createFromParcel(`in`: Parcel): ParcelableData {
                return ParcelableData(`in`)
            }

            override fun newArray(size: Int): Array<ParcelableData?> {
                return arrayOfNulls(size)
            }
        }
    }
}