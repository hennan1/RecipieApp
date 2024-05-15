package com.example.recipieapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val _categoriesState = mutableStateOf(recipieState())
    val categoriesState:State<recipieState> = _categoriesState

    data class recipieState(
        val loading : Boolean = true,
        val list : List<Category> = emptyList(),
        val error:String? = null
    )


}