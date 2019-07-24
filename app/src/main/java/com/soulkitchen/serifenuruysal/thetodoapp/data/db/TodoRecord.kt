package com.soulkitchen.serifenuruysal.thetodoapp.data.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

@Entity(tableName = "todo")
@Parcelize()
data class TodoRecord(@PrimaryKey(autoGenerate = true) val id: Long?,
                      @ColumnInfo(name = "title") val title: String,
                      @ColumnInfo(name = "content") val content: String) : Parcelable