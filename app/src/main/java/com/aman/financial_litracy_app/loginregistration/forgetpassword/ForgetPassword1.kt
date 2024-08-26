package com.aman.financial_litracy_app.loginregistration.forgetpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens

@Composable
fun ForgetPassword1(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Forgot Password")

        Text(text = "Oops. It happens to the best of us. Input your email address to fix the issue.")

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Button(onClick = {
            navController.navigate(Screens.ForgetPassword2.route)
        /* Handle submit */
        }) {
            Text(text = "Submit")
        }

        Text(text = "Already have an account? Log in")
    }
}
//@Preview(showBackground = true)
//@Composable
//fun fp1(){
//    ForgetPassword1()
//}