package com.kabbage.example.user

import io.reactivex.Single
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    fun getUsers(): Single<List<User>>
}