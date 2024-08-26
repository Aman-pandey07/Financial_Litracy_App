package com.aman.financial_litracy_app.data

data class Courses(
    val id: Int,
    val courseName: String,
    val courseImage: Int,
    val coursePrice: Double,
    val courseInstructor: String,
    val courseDuration: String,
    val courseDescription: String
)