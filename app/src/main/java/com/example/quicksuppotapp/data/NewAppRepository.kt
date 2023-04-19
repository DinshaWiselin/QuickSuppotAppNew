package com.example.quicksuppotapp.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.quicksuppotapp.data.model.Quotes

class NewAppRepository(private val api:NewQuoteApi) {
        val quotesData = MutableLiveData<List<Quotes>>()

        suspend fun getQuotes(limit:Int) {
            try {
              quotesData.value = api.retrofitService.getQuotes(limit)

            } catch (e: Exception) {
                Log.e("Repository", "Error loading data from API: $e")
            }
        }
}