package com.training.db_pry.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.training.db_pry.data.entity.Meeting
import com.training.db_pry.databinding.ActivityMainBinding
import com.training.db_pry.ui.view.adapter.ClickListener

import com.training.db_pry.ui.view.adapter.MeetAdapter
import com.training.db_pry.ui.viewmodel.MeetViewModel

class MainActivity : AppCompatActivity() {

    private val meetViewModel:MeetViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        meetViewModel.init(this)

        meetViewModel.meetsModel.observe(this) {  meets ->
            setAdapter(meets)
        }

        binding.addMeet.setOnClickListener {
            startActivity(Intent(this@MainActivity, CRUDMeet::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        meetViewModel.getMeets()
    }

    fun setAdapter(meets : MutableList<Meeting>){
        var adapter = MeetAdapter(meets)
        adapter.setClickListener(clickListener)
        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycler.adapter = adapter
    }

    var clickListener = object:ClickListener{
        override fun onClickMeet(view: View, meet: Meeting) {
            var intent = Intent(this@MainActivity, CRUDMeet::class.java)
            intent.putExtra("meeting",meet)
            startActivity(intent)
        }
    }
}