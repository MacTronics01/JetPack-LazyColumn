package com.example.lazycolumnjetpackcompose

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.lazycolumnjetpackcompose.data.Food
import com.example.lazycolumnjetpackcompose.ui.theme.LazyColumnJetpackComposeTheme

class ProfileActivity : ComponentActivity() {

    private val food: Food by lazy {
        intent?.getSerializableExtra(FOOD_ID) as Food
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnJetpackComposeTheme{
                ProfileScreen(food = food)
            }
        }
    }
    companion object{
        private const val FOOD_ID = "food_id"
        fun newIntent(context: Context, food: Food)=
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(FOOD_ID,food)
            }
    }
}
