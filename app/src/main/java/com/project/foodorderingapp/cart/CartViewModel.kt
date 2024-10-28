package com.project.foodorderingapp.cart


import androidx.lifecycle.ViewModel
import com.project.foodorderingapp.model.FoodItem
import com.project.foodorderingapp.model.FoodRepo
import com.project.foodorderingapp.model.OrderLine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel(
    foodRepo: FoodRepo = FoodRepo
) : ViewModel() {
    private val _orderLines: MutableStateFlow<List<OrderLine>> =
        MutableStateFlow(foodRepo.getCart())
    val orderLines: StateFlow<List<OrderLine>> = _orderLines.asStateFlow()
    fun addFoodItem(foodItem: FoodItem) {
        val existingOrderLine = _orderLines.value.find { it.foodItem.id == foodItem.id }
        if (existingOrderLine != null) {
            // If item already exists, increase the count
            updateCount(foodItem.id, existingOrderLine.count + 1)
        } else {
            // If item doesn't exist, add a new OrderLine with count 1
            _orderLines.value = _orderLines.value + OrderLine(foodItem, 1)
        }
    }

    fun increaseFoodCount(foodId: Long) {
        val currentCount = _orderLines.value.first { it.foodItem.id == foodId }.count
        updateCount(foodId, currentCount + 1)
    }

    fun decreaseFoodCount(foodId: Long) {
        val currentCount = _orderLines.value.first { it.foodItem.id == foodId }.count
        if (currentCount == 1) {
            removeFoodItem(foodId)
        } else {
            updateCount(foodId, currentCount - 1)

        }
    }

    fun removeFoodItem(foodId: Long) {
        _orderLines.value = _orderLines.value.filter { it.foodItem.id != foodId }
    }

    private fun updateCount(foodId: Long, count: Int) {
        _orderLines.value = _orderLines.value.map {
            if (it.foodItem.id == foodId) {
                it.copy(count = count)
            } else {
                it
            }
        }
    }








}