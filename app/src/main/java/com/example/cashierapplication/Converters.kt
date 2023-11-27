package com.example.cashierapplication

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromFood(food: Food): String {
        return gson.toJson(food)
    }

    @TypeConverter
    fun toFood(json: String): Food {
        val type = object : TypeToken<Food>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromDrink(drink: Drink): String {
        return gson.toJson(drink)
    }

    @TypeConverter
    fun toDrink(json: String): Drink {
        val type = object : TypeToken<Drink>() {}.type
        return gson.fromJson(json, type)
    }
}
