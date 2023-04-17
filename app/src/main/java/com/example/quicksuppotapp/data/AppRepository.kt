package com.example.quicksuppotapp.data

import android.util.Log
import androidx.lifecycle.MutableLiveData

class AppRepository(private val api: QuotesApi) {
    val quotesData = MutableLiveData<ApiResponseData>()

    suspend fun getQuotes(content:String) {
        try {
            quotesData.value = api.retrofitService.getQuotes(content)

        } catch (e: Exception) {
            Log.e("Repository", "Error loading data from API: $e")
        }
    }
}