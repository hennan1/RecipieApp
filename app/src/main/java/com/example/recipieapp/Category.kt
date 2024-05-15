package com.example.recipieapp

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class categoriesResponse(
    val categoriesList: List<Category>
)