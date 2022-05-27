package com.training.db_pry.domain

import android.content.Context
import com.training.db_pry.data.entity.Meeting
import com.training.db_pry.data.repository.MeetRepository

class UpdateMeet {

    var repository: MeetRepository

    constructor(context: Context){
        this.repository = MeetRepository(context)
    }

    suspend operator fun invoke(meet: Meeting):Boolean{
        return this.repository.updateMeet(meet)
    }
}