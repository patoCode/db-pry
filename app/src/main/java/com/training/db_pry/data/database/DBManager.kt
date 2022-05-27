package com.training.db_pry.data.database

import android.content.Context
import androidx.room.*
import com.training.db_pry.data.database.dao.MeetingDao
import com.training.db_pry.data.entity.Converters
import com.training.db_pry.data.entity.Meeting


@Database(
    entities = [Meeting::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DBManager : RoomDatabase(){

    abstract fun meetingDao():MeetingDao

    companion object{

        var INSTANCE: DBManager? = null

        fun getAppDB(context : Context): DBManager?{
            if(INSTANCE == null){
                synchronized(DBManager::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DBManager::class.java,"MettingDB").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyDB(){
            INSTANCE = null
        }

    }


}