package com.example.dota2stats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.viewmodel.Event
import com.example.dota2stats.viewmodel.HomeViewModel
import com.example.dota2stats.viewmodel.HomeViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        homeViewModel.getUserByPersonaName("TTV/Atila_TV")

        /**Con Flow pero sin el PrepareFlow*/
        CoroutineScope(Dispatchers.IO).launch {
            homeViewModel.state.collect { event ->
                when (event) {
                    is Event.Loading -> {
                        Log.i(TAG, "onCreate: Loading.............. ====")
                    }
                    is Event.Success -> {
                        Log.i(TAG, "onCreate: ${event.data?.get(0)?.userName}")
                        Log.i(TAG, "onCreate: ${event.data?.get(0)?.userId}")
                    }
                }
            }
        }


        /**Con LiveData*/
//        homeViewModel.listOfPlayersLiveData.observe(this) {
//            Log.d(TAG, "onCreate: ${it[0].userName} =========================")
//            Log.d(TAG, "onCreate: ${it[0].userId} =========================")
//        }
    }
}