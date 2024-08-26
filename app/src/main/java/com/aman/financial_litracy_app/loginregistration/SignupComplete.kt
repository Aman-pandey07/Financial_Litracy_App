package com.aman.financial_litracy_app.loginregistration

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens

@Composable
fun SignupComplete(navController: NavController) {
            // we have to implement popup feature here
    Button(onClick = {
    navController.navigate(Screens.SelectClass.route)
    /*TODO*/ }) {
        Text(text = "next")
    }
}