package com.practies.myapplication.model

data class Batch(
    val BatchName: String,
    val Count: Int,
    val Place: String,
    val Students: List<Any>,
    val _id: String
)