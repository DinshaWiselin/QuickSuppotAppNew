package com.example.quicksuppotapp.data

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
const val BASE_URL = "https://quotes15.p.rapidapi.com/quotes/"
val client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest: Request = chain.request().newBuilder().build()
    chain.proceed(newRequest)
}.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

    interface QuotesApiService {
        @Headers(
            "X-RapidAPI-Key: 1ae32ff67cmsh3eaef254fb49490p1a64ccjsn1588a4d80722",
            "X-RapidAPI-Host: quotes15.p.rapidapi.com"
        )
        @GET("random/")
        suspend fun getQuotes(@Query("language_code")content: String) : ApiResponseData
    }

object QuotesApi {
    val retrofitService:QuotesApiService by lazy { retrofit.create(QuotesApiService::class.java)}
}