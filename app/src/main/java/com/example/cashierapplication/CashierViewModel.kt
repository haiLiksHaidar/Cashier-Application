package com.example.cashierapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CashierViewModel(private val dao: CashierDao) : ViewModel() {

    // State Flow untuk menyimpan status aplikasi
    private val _state = MutableStateFlow(CashierState())
    val state: StateFlow<CashierState> get() = _state

    fun onEvent(event: CashierEvent) {
        when(event) {
            is CashierEvent.DeleteDrink -> {
                viewModelScope.launch {
                    dao.deleteDrink(event.drink)
                }
            }
            is CashierEvent.DeleteFood -> {
                viewModelScope.launch {
                    dao.deleteFood(event.food)
                }
            }
            is CashierEvent.DeleteTransactionItemById -> {
                viewModelScope.launch {
                    dao.deleteTransactionItemById(event.transactionItemId)
                }
            }
            is CashierEvent.foodImageResourceId -> TODO()
            is CashierEvent.GetDrinkById -> TODO()
            is CashierEvent.GetFoodById -> TODO()
            CashierEvent.GetTotalPrice -> TODO()
            CashierEvent.HideDialog ->
                _state.update { it.copy(
                isAddingTransactionItem = false
            ) }
            CashierEvent.SaveDrink -> {
                val drinkName = _state.value.drinkName
                val drinkPrice = _state.value.drinkPrice
                val drinkImageResourceId = _state.value.drinkImageResourceId

                if (drinkName.isBlank() || drinkPrice <= 0 || drinkImageResourceId == 0) {
                    // Handle invalid data
                } else {
                    val food = Food(
                        name = drinkName,
                        price = drinkPrice,
                        imageResourceId = drinkImageResourceId
                    )

                    viewModelScope.launch {
                        dao.upsertFood(food)
                        // Additional operations, e.g., calculating total price.
                    }

                    _state.update { it.copy(
                        isAddingTransactionItem = false,
                        foodName = "",
                        foodPrice = 0,
                        foodImageResourceId = 0
                    )}
                }
            }
            CashierEvent.SaveFood -> {
                val foodName = _state.value.foodName
                val foodPrice = _state.value.foodPrice
                val foodImageResourceId = _state.value.foodImageResourceId

                if (foodName.isBlank() || foodPrice <= 0 || foodImageResourceId == 0) {
                    // Handle invalid data
                } else {
                    val food = Food(
                        name = foodName,
                        price = foodPrice,
                        imageResourceId = foodImageResourceId
                    )

                    viewModelScope.launch {
                        dao.upsertFood(food)
                        // Additional operations, e.g., calculating total price.
                    }

                    _state.update { it.copy(
                        isAddingTransactionItem = false,
                        foodName = "",
                        foodPrice = 0,
                        foodImageResourceId = 0
                    )}
                }
            }


            is CashierEvent.SetFoodName -> {
                _state.update { it.copy(
                    foodName = event.foodName
                ) }
            }
            is CashierEvent.SetDrinkName -> {
                _state.update { it.copy(
                    drinkName = event.drinkName
                ) }
            }
            is CashierEvent.SetFoodPrice -> {
                _state.update { it.copy(
                    foodPrice = event.foodPrice
                )}
            }
            is CashierEvent.SetDrinkPrice -> {
                _state.update { it.copy(
                    drinkPrice = event.drinkPrice
                )}
            }
            is CashierEvent.drinkImageResourceId -> {
                _state.update { it.copy(
                    drinkImageResourceId = event.drinkImageResourceId
                ) }
            }
            is CashierEvent.foodImageResourceId -> {
                _state.update { it.copy(
                    foodImageResourceId = event.foodImageResourceId
                ) }
            }
            CashierEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingTransactionItem = true
                ) }
        }
    }
}}
