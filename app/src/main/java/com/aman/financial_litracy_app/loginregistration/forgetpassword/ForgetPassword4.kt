package com.aman.financial_litracy_app.loginregistration.forgetpassword

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens

@Composable
fun ForgetPassword4(navController: NavController) {
//password reset success popup
    Button(onClick = {
    navController.navigate(Screens.SignupComplete.route)
    /*TODO*/ }) {
        Text(text = "next")
    }
}