package com.example.cashierapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddFoodDialog(
    state: CashierState,
    onEvent: (CashierEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
                           onEvent(CashierEvent.HideDialog)
        },
        title = { Text(text = "Add Contact")},
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.foodName,
                    onValueChange = {
                         onEvent(CashierEvent.SetFoodName(it))
                    },
                    placeholder = {
                        Text(text = "Food Name")
                    }
                )
                TextField(
                    value = state.doodPrice,
                    onValueChange = {
                        onEvent(CashierEvent.SetFoodPrice(it.toIntOrNull() ?: 0))
                    },
                    placeholder = {
                        Text(text = "Price Food")
                    })
            }
        },
        confirmButton = {
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(CashierEvent.SaveFood)
                }) {
                        Text(text = "Save")
                }
            }
        })
}