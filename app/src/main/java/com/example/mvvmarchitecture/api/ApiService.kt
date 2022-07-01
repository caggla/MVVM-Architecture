package com.example.mvvmarchitecture.api

import com.example.mvvmarchitecture.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>

}