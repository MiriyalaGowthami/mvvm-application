package com.example.mvvmapplication

import java.io.Serializable

data class Subject(
    val name: String,
    val code: String,
    val details: String
) : Serializable
