package com.kabbage.example.todo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Todo(
    @Json(name = "id")
    val id: Int,
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "completed")
    val completed: Boolean
)