package com.training.db_pry.ui.view.adapter

import android.view.View
import com.training.db_pry.data.entity.Meeting

interface ClickListener {

    fun onClickMeet(view:View, meet : Meeting)
}