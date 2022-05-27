package com.training.db_pry.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.training.db_pry.data.entity.Meeting
import com.training.db_pry.databinding.ActivityCrudmeetBinding
import com.training.db_pry.ui.viewmodel.MeetViewModel
import java.util.*


class CRUDMeet : AppCompatActivity() {

    private val meetViewModel: MeetViewModel by viewModels()
    private lateinit var binding: ActivityCrudmeetBinding

    private var meet : Meeting? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudmeetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.extras!= null){
            meet = intent.extras!!.getSerializable("meeting") as Meeting?
            binding.tfTitle.setText(meet?.title)
            binding.tfDesc.setText(meet?.desc)
            binding.tfStatus.setText(meet?.status)
        }

        meetViewModel.init(this)
        meetViewModel.resutlInsert.observe(this){ result ->
            finish()
        }

        meetViewModel.resutlUpdate.observe(this){ result ->
            finish()
        }
    }

    fun saveMeet(view: View) {
        if(meet == null){
             meet = Meeting(
                id = 0,
                title = binding.tfTitle.text.toString(),
                desc =  binding.tfDesc.text.toString(),
                hour = binding.tfHour.text.toString(),
                color = binding.tfColor.text.toString(),
                status = binding.tfStatus.text.toString(),
                create = Date()
            )
            meetViewModel.insertMeet(meet!!)
        }else{
            meet!!.title = binding.tfTitle.text.toString()
            meet!!.desc =  binding.tfDesc.text.toString()
            meet!!.status = binding.tfStatus.text.toString()
            meetViewModel.updateMeet(meet!!)
        }


    }

    fun backToMain(view: View) {
        val returnBtn = Intent(
            applicationContext,
            MainActivity::class.java
        )
        startActivity(returnBtn)
    }

    fun editMeet(view: View) {
        saveMeet(view)

    }
}