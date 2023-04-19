package com.example.quicksuppotapp.data

import com.example.quicksuppotapp.data.model.Quotes
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
//const val BASE_URL1 = "https://quotes15.p.rapidapi.com/quotes/"
const val BASE_URL1 = "https://api.api-ninjas.com/v1/"
val client1: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest: Request = chain.request().newBuilder().build()
    chain.proceed(newRequest)
}.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL1)
    .build()

    interface QuotesApiService {
        @Headers(
            //"X-RapidAPI-Key: 1ae32ff67cmsh3eaef254fb49490p1a64ccjsn1588a4d80722",
           "X-Api-Key: WsJ1X25PenIfSzZtQQplbA==mtKlsN5RRueGPWbp",
            //"X-RapidAPI-Host: quotes15.p.rapidapi.com"
        )
        //@GET("random/")
        @GET("quotes?category=happiness")
        suspend fun getQuotes(@Query("limit")limit:Int) :List<Quotes>
    }

object QuotesApi {
    val retrofitService:QuotesApiService by lazy { retrofit.create(QuotesApiService::class.java)}
}