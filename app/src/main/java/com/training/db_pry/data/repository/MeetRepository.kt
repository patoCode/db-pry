package com.training.db_pry.data.repository

import android.content.Context
import com.training.db_pry.data.database.DBManager
import com.training.db_pry.data.database.dao.MeetingDao
import com.training.db_pry.data.entity.Meeting

class MeetRepository  {

    private lateinit var meetDao : MeetingDao

    constructor(context: Context){
        var db = DBManager.getAppDB(context)
        this.meetDao = db!!.meetingDao()
    }

    suspend fun getAll():MutableList<Meeting>{
         return meetDao.getAll()
    }

    suspend fun insertMeet(meet:Meeting):Boolean{
        meetDao.insert(meet)
        return true
    }

    suspend fun updateMeet(meet:Meeting):Boolean{
        meetDao.update(meet)
        return true
    }


}