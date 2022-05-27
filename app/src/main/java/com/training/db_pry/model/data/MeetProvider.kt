package com.training.db_pry.model.data

import com.training.db_pry.model.data.entity.Metting
import java.util.*

class MeetProvider {
    companion object{

        fun getMeets():MutableList<Metting>{
            return meets
        }

        private val meets = listOf(
            Metting(
                id=1,
                title = "algo",
                tag = "algo",
                create = Date()
            ),
            Metting(
                id=2,
                title = "MVVN",
                tag = "algo",
                create = Date()
            ),
            Metting(
                id=3,
                title = "Clase",
                tag = "algo",
                create = Date()
            ),
        ).toMutableList()
    }



}