package com.training.db_pry.model.data

import android.content.Context
import androidx.room.*
import com.training.db_pry.model.data.dao.MettingDao
import com.training.db_pry.model.data.entity.Converters
import com.training.db_pry.model.data.entity.Metting

@Database(
    entities = [Metting::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DBManager : RoomDatabase(){

    abstract fun mettingDao():MettingDao

    companion object{

        var INSTANCE:DBManager? = null

        fun getAppDB(context : Context):DBManager?{
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