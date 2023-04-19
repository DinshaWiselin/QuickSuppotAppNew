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
import retrofit2.http.Query

const val BASE_URL = "https://api.api-ninjas.com/v1/"
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
interface NewApiService {
    @Headers(
        "X-Api-Key: WsJ1X25PenIfSzZtQQplbA==mtKlsN5RRueGPWbp",
    )
    @GET("quotes?category=success")
    suspend fun getQuotes(@Query("limit")limit:Int) :List<Quotes>
}
object NewQuoteApi {
    val retrofitService:NewApiService by lazy { retrofit.create(NewApiService::class.java)}
}