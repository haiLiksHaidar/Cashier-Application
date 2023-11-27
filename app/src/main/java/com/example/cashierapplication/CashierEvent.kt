package com.example.cashierapplication

sealed interface CashierEvent {
    data class DeleteFood(val food: Food) : CashierEvent
    data class DeleteDrink(val drink: Drink) : CashierEvent
    data class DeleteTransactionItemById(val transactionItemId: Int) : CashierEvent
    data class GetFoodById(val foodId: Int) : CashierEvent
    data class GetDrinkById(val drinkId: Int) : CashierEvent
    object GetTotalPrice : CashierEvent
    object ShowDialog: CashierEvent
    object HideDialog: CashierEvent
    object SaveDrink: CashierEvent
    object SaveFood: CashierEvent
    data class SetFoodName(val foodName: String): CashierEvent
    data class SetDrinkName(val drinkName: String): CashierEvent
    data class SetFoodPrice (val foodPrice: Int): CashierEvent
    data class SetDrinkPrice (val drinkPrice: Int): CashierEvent
    data class drinkImageResourceId (val drinkImageResourceId: Int): CashierEvent
    data class foodImageResourceId (val foodImageResourceId: Int): CashierEvent
}