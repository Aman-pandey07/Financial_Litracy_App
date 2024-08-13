package com.aman.financial_litracy_app.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController){
    Column {
        Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
    }
}