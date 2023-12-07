package com.kabbage.example.todo

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoService {
    @GET("/todos")
    fun getTodos(@Query("userId") userId: Int? = null): Single<List<Todo>>
}