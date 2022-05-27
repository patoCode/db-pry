package com.training.db_pry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.db_pry.model.data.MeetProvider
import com.training.db_pry.model.data.entity.Metting

class MeetViewModel:ViewModel() {

    val meetModel = MutableLiveData<Metting>()
    val meetsModel = MutableLiveData<MutableList<Metting>>().apply { postValue(mutableListOf()) }


    fun getMeets(){
        meetsModel.postValue(MeetProvider.getMeets())

    }


}