package com.example.lazycolumnjetpackcompose.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.lazycolumnjetpackcompose.FoodListItem
import com.example.lazycolumnjetpackcompose.data.DataProvider
import com.example.lazycolumnjetpackcompose.data.Food

@Composable
fun BackHomeContent(navigateToProfile: (Food) ->Unit){
    val foods = remember { DataProvider.foodList}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items= foods,
            itemContent = {
                FoodListItem(food =it, navigateToProfile)
            }
        )
    }
}