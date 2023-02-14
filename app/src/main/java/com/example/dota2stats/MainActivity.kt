package com.example.dota2stats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.viewmodel.HomeViewModel
import com.example.dota2stats.viewmodel.HomeViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
        homeViewModel.getUserByPersonaName("Atila")
        val list = homeViewModel.listOfPlayers
        Log.i(TAG, "onCreate: ${list[0].userName}")

    }
}