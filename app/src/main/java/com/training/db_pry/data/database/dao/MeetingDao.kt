package com.training.db_pry.data.database.dao

import androidx.room.*
import com.training.db_pry.data.entity.Meeting

@Dao
interface MeetingDao {

    @Query("SELECT * FROM meeting_table ORDER BY title DESC")
    suspend fun getAll():MutableList<Meeting>

    @Query("SELECT * FROM meeting_table WHERE id = :id")
    suspend fun getById(id:Int):Meeting

    @Update
    suspend fun update(meeting: Meeting)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(meetings:List<Meeting>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(meeting:Meeting)

    @Delete
    suspend fun delete(meeting: Meeting)

}