package com.example.cashierapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CashierDao {
    @Upsert
    suspend fun upsertFood(food: Food)

    @Upsert
    suspend fun upsertDrink(drink: Drink)

    @Delete
    suspend fun deleteFood(food: Food)

    @Delete
    suspend fun deleteDrink(drink: Drink)

    @Query("DELETE FROM DataTransactionItem WHERE id = :transactionItemId")
    suspend fun deleteTransactionItemById(transactionItemId: Int)

    @Query("SELECT * FROM Food WHERE id = :foodId")
    fun getFoodById(foodId: Int): Flow<Food>

    @Query("SELECT * FROM Drink WHERE id = :drinkId")
    fun getDrinkById(drinkId: Int): Flow<Drink>

    @Query("SELECT SUM(totalPrice) FROM DataTransactionItem")
    fun getTotalPrice(): Flow<Int>
}