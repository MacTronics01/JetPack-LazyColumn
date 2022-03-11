package com.example.lazycolumnjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lazycolumnjetpackcompose.data.Food

@Composable
fun FoodListItem(food:Food, navigateToProfile: (Food) -> Unit){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
    Row(
        Modifier.clickable { navigateToProfile(food) }
    ) {
        FoodImage(food = food)
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(text = food.title, style = typography.h6)
            Text(text = "VIEW DETAIL", style = typography.caption)
        }
    } }
}
@Composable
private fun FoodImage(food: Food){
    Image(painter = painterResource(id = food.foodImageId),
        contentDescription =null,
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .padding(8.dp)
        .size(84.dp)
        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}