package com.example.cashierapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataTransactionItem(
    val food: Food?,
    val drink: Drink?,
    val quantity: Int,
    val totalPrice: Int // Tambahkan kolom totalPrice
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
