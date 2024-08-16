package com.aman.financial_litracy_app.loginregistration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R

@Composable
fun SelectClass(){

    data class ClassItem(val name: String, val iconResId: Int)
    val classList = listOf(
        ClassItem("UKG", R.drawable.abc_icon),
        ClassItem("LKG", R.drawable.books_icon),
        ClassItem("Class 1", R.drawable.backpack_icon),
        ClassItem("Class 2", R.drawable.planet_icon),
        ClassItem("Class 3", R.drawable.medal_icon),
        ClassItem("Class 4", R.drawable.test_tubes_icon),
        // Add more class items as needed
    )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
        Text(
            text = "Tell us about your child",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

//        Column(
//            modifier = Modifier.weight(1f),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            ClassButton(text = "UKG", iconResId = R.drawable.abc_icon)
//            ClassButton(text = "LKG", iconResId = R.drawable.books_icon)
//            ClassButton(text = "Class 1", iconResId = R.drawable.backpack_icon)
//            ClassButton(text = "Class 2", iconResId = R.drawable.planet_icon)
//            ClassButton(text = "Class 3", iconResId = R.drawable.medal_icon)
//            ClassButton(text = "Class 4", iconResId = R.drawable.test_tubes_icon)
//        }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(classList) { classItem ->
                    ClassButton(text = classItem.name, iconResId = classItem.iconResId)
                }
            }

        Button(
            onClick = { /* Handle next button click */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Next")
        }
    }
    }

    @Composable
    fun ClassButton(text: String, iconResId: Int) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { /* Handle class selection */ },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Text(text = text, style = MaterialTheme.typography.bodyMedium)
            }

        }
}

@Preview(showBackground = true)
@Composable
fun SelectClassPreview(){
    SelectClass()
}