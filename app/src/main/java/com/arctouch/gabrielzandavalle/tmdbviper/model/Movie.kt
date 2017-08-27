package com.arctouch.gabrielzandavalle.tmdbviper.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Movie(
        val id: String = "",
        @SerializedName("poster_path")
        val posterPath: String = "",
        val title: String = "",
        val overview: String = "",
        @SerializedName("release_date")
        val releaseDate: String = ""
) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(posterPath)
        dest?.writeString(title)
        dest?.writeString(overview)
        dest?.writeString(releaseDate)
    }
}
