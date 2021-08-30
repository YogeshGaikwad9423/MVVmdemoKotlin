package com.example.mvvmapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
     companion object{
       //  https://gorest.co.in/public/v1/users?page=1
         val BASE_URL="https://gorest.co.in/public/"
         fun getretroInstance():Retrofit{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
         }
     }
}