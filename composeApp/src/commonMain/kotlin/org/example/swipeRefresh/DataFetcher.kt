package org.example.swipeRefresh

import kotlinx.coroutines.delay

class DataFetcher {
    suspend fun fetchData(){
        delay(2000)
        //Logic to fetch the data
    }
}