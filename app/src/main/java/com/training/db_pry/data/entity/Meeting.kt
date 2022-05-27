package com.training.db_pry.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName = "meeting_table")
data class Meeting(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var desc: String,
    @ColumnInfo(name = "hour") val hour: String,
    @ColumnInfo(name = "color") val color: String,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "create") val create: Date

) : Serializable
