package com.example.recipieapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

//first this line creates a link with the url provided and the converts the gson obj found their
// to use them in kotlin
val retroFit = Retrofit.Builder().baseUrl("www.themealdb.com/api/json/v1/1/").
addConverterFactory(GsonConverterFactory.create()).build()

val recipieService = retroFit.create(apiService::class.java)

interface apiService{
    @GET("categories.php")//used from the pakage retrofit to access online

    //suspend function is used to keep running a spsecific function
    // in the background while the ui thread can keep running for the user
    suspend fun getCategories():categoriesResponse


}