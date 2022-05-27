package com.training.db_pry.model.data.dao

import androidx.room.*
import com.training.db_pry.model.data.entity.Metting

@Dao
interface MettingDao {

    @Query("SELECT * FROM metting_table ORDER BY title DESC")
    fun getAll():List<Metting>

    @Query("SELECT * FROM metting_table WHERE id = :id")
    fun getAlgetById(id:Int):Metting

    @Update
    fun update(metting: Metting)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mettings:List<Metting>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(metting:Metting)

    @Delete
    fun delete(metting: Metting)

}