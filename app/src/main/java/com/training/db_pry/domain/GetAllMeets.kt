package com.training.db_pry.domain

import android.content.Context
import com.training.db_pry.data.repository.MeetRepository
import com.training.db_pry.data.entity.Meeting

class GetAllMeets {

    var repository: MeetRepository

    constructor(context:Context){
        this.repository = MeetRepository(context)
    }

    suspend operator fun invoke() : MutableList<Meeting>{
        return this.repository.getAll()
    }
}