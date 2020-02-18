package com.manage.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manage.android.data.TodoRepository
import com.manage.android.data.local.db.dao.Category
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

//    val categories: LiveData<List<Category>> = mCategories

    private val _categories = MutableLiveData<List<Category>>()

    val categories: LiveData<List<Category>> = _categories

    init {
        getCategories()
    }

    fun getCategories() {
        viewModelScope.launch {
            _categories.value = repository.getAllCategory()
        }
    }

    fun insertCategory(category: Category) {
        viewModelScope.launch {
            repository.insertCategory(category)
        }
    }


}