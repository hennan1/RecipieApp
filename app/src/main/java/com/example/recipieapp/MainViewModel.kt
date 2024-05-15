package com.example.recipieapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private val _categoriesState = mutableStateOf(recipieState())
    val categoriesState:State<recipieState> = _categoriesState

    fun fetchCategory(){
        //The coroutine is the background that keeps on running while
        //suspend function does its work
        viewModelScope.launch {
            try {
                val response = recipieService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categoriesList,
                    loading = false,
                    error = null,

                )

            }catch (e:Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching the category"
                )
            }
        }
    }

    data class recipieState(
        val loading : Boolean = true,
        val list : List<Category> = emptyList(),
        val error:String? = null
    )


}