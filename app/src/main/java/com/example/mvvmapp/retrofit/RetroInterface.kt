package com.example.mvvmapp.retrofit

import com.example.mvvmapp.data.Usermodel
import com.example.mvvmapp.data.Welcome7
import retrofit2.Call
import retrofit2.http.GET

interface RetroInterface {
    @GET("v1/users?page=1")
    fun getuserlist(): Call<Welcome7>
}