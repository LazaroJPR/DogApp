package com.example.encomp.data

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("breeds/image/random")
    suspend fun getRandomDog(): Response<DogResponse>

    companion object{
        private const val BASE_URL = "https://dog.ceo/api/"

        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val client = okhttp3.OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        fun create(): DogApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DogApi::class.java)
        }
    }
}
