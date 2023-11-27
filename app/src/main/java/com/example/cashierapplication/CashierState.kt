package com.example.cashierapplication

data class CashierState(
    val foods: List<Food> = emptyList(),
    val foodName: String = "",
    val foodPrice: Int = 0,
    val foodImageResourceId: Int = 0,
    val drinkName: String = "",
    val drinkPrice: Int = 0 ,
    val drinkImageResourceId: Int = 0,
    val drinks: List<Drink> = emptyList(),
    val transactionItems: List<DataTransactionItem> = emptyList(),
    val selectedFood: Food? = null,
    val selectedDrink: Drink? = null,
    val isAddingTransactionItem: Boolean = false,
    val totalPrice: Int = 0
) {
    val doodPrice: String
        get() = foodPrice.toString()
}

