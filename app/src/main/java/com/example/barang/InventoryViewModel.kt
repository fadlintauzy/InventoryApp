package com.example.barang

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InventoryViewModel : ViewModel() {

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName.asStateFlow()

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items.asStateFlow()

    fun setUserName(name: String) {
        _userName.value = name
    }

    fun addItem(name: String, quantity: Int) {
        if (name.isBlank() || quantity <= 0) return

        val newItem = Item(name, quantity)
        _items.update { currentList ->
            currentList + newItem
        }
    }
}