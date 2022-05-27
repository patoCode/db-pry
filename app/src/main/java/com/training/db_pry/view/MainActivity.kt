package com.training.db_pry.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.training.db_pry.databinding.ActivityMainBinding
import com.training.db_pry.model.data.DBManager
import com.training.db_pry.model.data.entity.Metting
import com.training.db_pry.view.adapter.MeetAdapter
import com.training.db_pry.viewmodel.MeetViewModel
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private val meetViewModel:MeetViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        meetViewModel.meetsModel.observe(this) {  meets ->
            setAdapter(meets)
        }

        binding.addMeet.setOnClickListener {
            meetViewModel.getMeets()
        }

    }

//        lifecycleScope.launch{
//            val list = listOf<Metting>(
//                Metting("REUNION", "algo", Date()),
//                Metting("REUNION 2", "algo2", Date()),
//                Metting("REUNION 3", "algo3", Date()),
//            )
//
//            val db = DBManager.getAppDB(this@MainActivity)
//            db?.mettingDao()?.insert(list)
//
//            val mettings = db?.mettingDao()?.getAll()
//            Log.d("NMETTINGS", "METTTINGS ${mettings?.size}")
//        }

    fun setAdapter(meets : MutableList<Metting>){
        var adapter = MeetAdapter(meets)
        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycler.adapter = adapter
    }
}