package com.example.cashierapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Drink(
    val name: String,
    val price: Int,
    val imageResourceId: Int, // ID gambar minuman
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)
