package com.training.db_pry.model.data.entity

import androidx.room.TypeConverter
import java.util.*


class Converters {
    @TypeConverter
    fun fromTimestamp(value:Long?): Date?{
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromLong(date : Date?):Long?{
        return date?.time?.toLong()
    }


}