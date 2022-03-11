package com.example.lazycolumnjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lazycolumnjetpackcompose.data.Food

@Composable
fun ProfileScreen(food: Food){
    val scrollState = rememberScrollState()

    Column( modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            androidx.compose.material.Surface() {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    ProfileHeader(food =food, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(food =food, containerHeight = this@BoxWithConstraints.maxHeight)

                }
            }

        }

    }
}
@Composable
private fun ProfileHeader(
    food: Food,
    containerHeight: Dp
){
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = food.foodImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
@Composable
private fun ProfileContent(food: Food, containerHeight: Dp){
    Column {
        //TODO:
        Title(food =food)
        ProfileProperty(label = stringResource(id = R.string.price) , value =food.prize)
        ProfileProperty(label = stringResource(id = R.string.quantity) , value =food.quantity.toString())
        ProfileProperty(label = stringResource(id = R.string.personality) , value =food.description)
        Spacer(modifier = Modifier.height((containerHeight -0.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Title(food: Food){
    Column( modifier =Modifier.padding(16.dp)) {
        Text(
            text=food.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )

    }
}
@Composable
private fun ProfileProperty(label: String, value: String){
    Column( modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
        modifier = Modifier.height(24.dp),
        style = MaterialTheme.typography.caption
        )
        Text(
            text =value,
        modifier = Modifier.height(24.dp),
        style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}