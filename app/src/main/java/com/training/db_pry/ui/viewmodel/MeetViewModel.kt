package com.training.db_pry.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.db_pry.data.entity.Meeting
import com.training.db_pry.domain.GetAllMeets
import com.training.db_pry.domain.InsertMeet
import com.training.db_pry.domain.UpdateMeet
import kotlinx.coroutines.launch


class MeetViewModel:ViewModel() {

    // USE CASE
    lateinit var getAllMeets : GetAllMeets
    lateinit var insertMeets : InsertMeet
    lateinit var updateMeets : UpdateMeet

    val resutlInsert = MutableLiveData<Boolean>()
    val resutlUpdate = MutableLiveData<Boolean>()
    val meetModel = MutableLiveData<Meeting>()
    val meetsModel = MutableLiveData<MutableList<Meeting>>().apply { postValue(mutableListOf()) }

    fun init(context:Context){
        this.getAllMeets = GetAllMeets(context)
        this.insertMeets = InsertMeet(context)
        this.updateMeets = UpdateMeet(context)
    }

    fun getMeets(){
        viewModelScope.launch {
            meetsModel.postValue(getAllMeets())
        }
    }

    fun insertMeet(meet:Meeting){
        viewModelScope.launch {
            var result = insertMeets(meet)
            resutlInsert.postValue(result)
        }
    }

    fun updateMeet(meet:Meeting){
        viewModelScope.launch {
            var result = updateMeets(meet)
            resutlUpdate.postValue(result)
        }
    }
}